package com.fieldontrack.kmm.android.composables.navigation

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler
import com.fieldontrack.kmm.featurecore.Navigation

@Composable
fun Navigation.HandleBackButton() {
    BackHandler { // catching the back button to update the DKMPViewModel
        exitScreen()
    }
}