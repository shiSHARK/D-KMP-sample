package eu.baroncelli.dkmpsample.shared

import com.russhwolf.settings.MockSettings
import eu.baroncelli.dkmpsample.shared.datalayer.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.CoroutineContext
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import eu.baroncelli.dkmpsample.persistence.localdb.createIosDB
import eu.baroncelli.dkmpsample.shared.datalayer.sources.localsettings.UserSettingsImpl
import mylocal.db.LocalDb

actual val testCoroutineContext: CoroutineContext =
    newSingleThreadContext("testRunner")

actual fun runBlockingTest(block: suspend CoroutineScope.() -> Unit) =
    runBlocking(testCoroutineContext) { this.block() }

actual fun getTestRepository() : Repository {
    val db = createIosDB()
    return Repository(db, UserSettingsImpl( MockSettings()), false)
}