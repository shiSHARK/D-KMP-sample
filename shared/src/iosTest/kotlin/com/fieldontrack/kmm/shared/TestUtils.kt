package com.fieldontrack.kmm.shared

import com.fieldontrack.kmm.feature.core.Repository
import com.fieldontrack.kmm.persistence.localdb.createIosDB
import com.fieldontrack.kmm.persistence.localsettings.UserSettingsImpl
import com.fieldontrack.kmm.network.webservices.ApiClient
import com.russhwolf.settings.MockSettings
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext

actual val testCoroutineContext: CoroutineContext =
    newSingleThreadContext("testRunner")

actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

actual fun getTestRepository(): Repository {
    val db = createIosDB()
    val network = ApiClient()
    return Repository(db, UserSettingsImpl(MockSettings()), network, false)
}