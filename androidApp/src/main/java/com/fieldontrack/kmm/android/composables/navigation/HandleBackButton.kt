package com.fieldontrack.kmm.android.composables.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import com.fieldontrack.kmm.feature.core.Navigation

@Composable
fun Navigation.HandleBackButton() {
    BackHandler { // catching the back button to update the DKMPViewModel
        exitScreen()
    }
}