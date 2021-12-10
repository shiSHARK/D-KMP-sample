package com.fieldontrack.kmm.shared

import com.fieldontrack.kmm.featurecore.Repository
import com.fieldontrack.kmm.persistence.localdb.createAndroidTestDB
import com.fieldontrack.kmm.persistence.localsettings.UserSettingsImpl
import com.fieldontrack.kmm.shared.datalayer.sources.webservices.ApiClient
import com.russhwolf.settings.MockSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executors
import kotlin.coroutines.CoroutineContext

actual val testCoroutineContext: CoroutineContext =
    Executors.newSingleThreadExecutor().asCoroutineDispatcher()

actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

actual fun getTestRepository(): Repository {
    val db = createAndroidTestDB()
    val network = ApiClient()
    return Repository(db, UserSettingsImpl(MockSettings()), network, false)
}