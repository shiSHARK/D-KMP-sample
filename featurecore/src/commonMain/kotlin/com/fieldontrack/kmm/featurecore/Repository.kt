package com.fieldontrack.kmm.featurecore

import com.fieldontrack.kmm.coreinterfaces.DataBase
import com.fieldontrack.kmm.coreinterfaces.NetworkClient
import com.fieldontrack.kmm.coreinterfaces.UserSettings
import com.fieldontrack.kmm.entities.countries.CountryExtraData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.native.concurrent.ThreadLocal

class Repository(
    val localDb: DataBase,
    val localSettings: UserSettings,
    val webservices: NetworkClient,
    val useDefaultDispatcher: Boolean = true
) {

    //    internal val webservices by lazy { ApiClient() }
//    internal val localDb by lazy { LocalDb(sqlDriver) }
//    internal val localSettings by lazy { MySettings(settings) }
    val runtimeCache: MemoryCache get() = CacheObjects

    // we run each repository function on a Dispatchers.Default coroutine
    // we pass useDefaultDispatcher=false just for the TestRepository instance
    suspend fun <T> withRepoContext(block: suspend () -> T): T {
        return if (useDefaultDispatcher) {
            withContext(Dispatchers.Default) {
                block()
            }
        } else {
            block()
        }
    }

}

@ThreadLocal
private object CacheObjects : MemoryCache {
    // here is the repository data we decide to just cache temporarily (for the runtime session),
    // rather than caching it permanently in the local db or local settings

    override val countryExtraData: MutableMap<String, CountryExtraData> by lazy { mutableMapOf() }

}


interface MemoryCache {
    val countryExtraData: MutableMap<String, CountryExtraData>
}