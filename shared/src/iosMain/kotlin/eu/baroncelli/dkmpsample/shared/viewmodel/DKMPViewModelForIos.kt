package eu.baroncelli.dkmpsample.shared.viewmodel

import eu.baroncelli.dkmpsample.persistence.localdb.createIosDB
import eu.baroncelli.dkmpsample.shared.datalayer.Repository
import eu.baroncelli.dkmpsample.shared.datalayer.sources.localsettings.UserSettingsImpl
import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


fun DKMPViewModel.Factory.getIosInstance(): DKMPViewModel {
    val db = createIosDB()
    val userSettings = UserSettingsImpl()
    val repository = Repository(db, userSettings)
    return DKMPViewModel(repository)
}


// this is required, because default arguments of Kotlin functions are currently not exposed to Objective-C or Swift
// https://youtrack.jetbrains.com/issue/KT-41908
fun DKMPViewModel.getDefaultAppState(): AppState {
    return AppState()
}

// this function notifies of any state changes to the iOS AppObservableObject class
// hopefully this code will eventually be provided by an official Kotlin function
// https://youtrack.jetbrains.com/issue/KT-41953
fun DKMPViewModel.onChange(provideNewState: ((AppState) -> Unit)): Closeable {

    val job = Job()

    stateFlow.onEach {
        provideNewState(it)
    }.launchIn(
        CoroutineScope(Dispatchers.Main + job)
    )

    return object : Closeable {
        override fun close() {
            job.cancel()
        }
    }

}