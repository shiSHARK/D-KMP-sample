package com.fieldontrack.kmm.shared.viewmodel

import android.content.Context
import com.fieldontrack.kmm.feature.core.DKMPViewModel
import com.fieldontrack.kmm.feature.core.Repository
import com.fieldontrack.kmm.persistence.localdb.createAndroidDB
import com.fieldontrack.kmm.persistence.localsettings.UserSettingsImpl
import com.fieldontrack.kmm.shared.datalayer.sources.webservices.ApiClient
import com.fieldontrack.kmm.shared.viewmodel.screens.navigationSettings


fun DKMPViewModel.Factory.getAndroidInstance(context: Context): DKMPViewModel {
    val db = createAndroidDB(context)
    val userSettings = UserSettingsImpl()
    val network = ApiClient()
    val repository = Repository(db, userSettings, network)
    return DKMPViewModel(repository, navigationSettings)
}