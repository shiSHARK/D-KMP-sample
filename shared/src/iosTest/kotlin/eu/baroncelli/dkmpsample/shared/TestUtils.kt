package com.fieldontrack.kmm.shared

import com.russhwolf.settings.MockSettings
import com.fieldontrack.kmm.shared.datalayer.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import com.fieldontrack.kmm.persistence.localdb.createIosDB
import com.fieldontrack.kmm.shared.datalayer.sources.localsettings.UserSettingsImpl
import mylocal.db.LocalDb

actual val testCoroutineContext: CoroutineContext =
    newSingleThreadContext("testRunner")

actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

actual fun getTestRepository() : Repository {
    val db = createIosDB()
    return Repository(db, UserSettingsImpl( MockSettings()), false)
}