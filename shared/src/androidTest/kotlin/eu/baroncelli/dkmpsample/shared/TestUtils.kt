package com.fieldontrack.kmm.shared

import com.russhwolf.settings.MockSettings
import com.fieldontrack.kmm.persistence.localdb.createAndroidTestDB
import com.fieldontrack.kmm.shared.datalayer.Repository
import com.fieldontrack.kmm.shared.datalayer.sources.localsettings.UserSettingsImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

actual val testCoroutineContext: CoroutineContext =
    Executors.newSingleThreadExecutor().asCoroutineDispatcher()
actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

actual fun getTestRepository() : Repository {
    val db = createAndroidTestDB()
    return Repository(db, UserSettingsImpl( MockSettings()), false)
}