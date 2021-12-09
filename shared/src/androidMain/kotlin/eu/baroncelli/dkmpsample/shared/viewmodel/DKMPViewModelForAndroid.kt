package com.fieldontrack.kmm.shared.viewmodel

import android.content.Context
import com.fieldontrack.kmm.persistence.localdb.createAndroidDB
import com.fieldontrack.kmm.shared.datalayer.Repository
import com.fieldontrack.kmm.shared.datalayer.sources.localsettings.UserSettingsImpl


fun DKMPViewModel.Factory.getAndroidInstance(context: Context): DKMPViewModel {
    val db = createAndroidDB(context)
    val userSettings = UserSettingsImpl()
    val repository = Repository(db, userSettings)
    return DKMPViewModel(repository)
}