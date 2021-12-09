package eu.baroncelli.dkmpsample.shared.viewmodel

import android.content.Context
import eu.baroncelli.dkmpsample.persistence.localdb.createAndroidDB
import eu.baroncelli.dkmpsample.shared.datalayer.Repository


fun DKMPViewModel.Factory.getAndroidInstance(context: Context): DKMPViewModel {
    val db = createAndroidDB(context)
    val repository = Repository(db)
    return DKMPViewModel(repository)
}