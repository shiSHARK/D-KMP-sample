package com.fieldontrack.kmm.shared.viewmodel

import com.fieldontrack.kmm.featurecore.AppState
import com.fieldontrack.kmm.featurecore.DKMPViewModel
import com.fieldontrack.kmm.featurecore.Repository
import com.fieldontrack.kmm.persistence.localdb.createIosDB
import com.fieldontrack.kmm.shared.datalayer.sources.localsettings.UserSettingsImpl
import com.fieldontrack.kmm.shared.datalayer.sources.webservices.ApiClient
import com.fieldontrack.kmm.shared.viewmodel.screens.navigationSettings
import io.ktor.utils.io.core.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


fun DKMPViewModel.Factory.getIosInstance(): DKMPViewModel {
    val db = createIosDB()
    val userSettings = UserSettingsImpl()
    val network = ApiClient()
    val repository = Repository(db, userSettings, network)
    return DKMPViewModel(repository, navigationSettings)
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