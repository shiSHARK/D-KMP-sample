package eu.baroncelli.dkmpsample.shared.viewmodel

import android.content.Context
import eu.baroncelli.dkmpsample.persistence.localdb.createAndroidDB
import eu.baroncelli.dkmpsample.shared.datalayer.Repository
import eu.baroncelli.dkmpsample.shared.datalayer.sources.localsettings.UserSettingsImpl


fun DKMPViewModel.Factory.getAndroidInstance(context: Context): DKMPViewModel {
    val db = createAndroidDB(context)
    val userSettings = UserSettingsImpl()
    val repository = Repository(db, userSettings)
    return DKMPViewModel(repository)
}