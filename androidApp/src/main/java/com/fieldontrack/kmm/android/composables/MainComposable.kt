package com.fieldontrack.kmm.android.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.fieldontrack.kmm.android.composables.navigation.Router
import com.fieldontrack.kmm.shared.viewmodel.DKMPViewModel

@Composable
fun MainComposable(model: DKMPViewModel) {
    val appState by model.stateFlow.collectAsState()
    println("FOT-KMM: recomposition Index: "+appState.recompositionIndex.toString())
    val dkmpNav = appState.getNavigation(model)
    dkmpNav.Router()
}

