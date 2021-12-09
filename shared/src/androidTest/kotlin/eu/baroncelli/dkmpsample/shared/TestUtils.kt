package eu.baroncelli.dkmpsample.shared

import com.russhwolf.settings.MockSettings
import eu.baroncelli.dkmpsample.persistence.localdb.createAndroidTestDB
import eu.baroncelli.dkmpsample.shared.datalayer.Repository
import eu.baroncelli.dkmpsample.shared.datalayer.sources.localsettings.UserSettingsImpl
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