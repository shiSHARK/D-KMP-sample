package eu.baroncelli.dkmpsample.android.composables.navigation

import androidx.compose.runtime.Composable
import androidx.activity.compose.BackHandler
import eu.baroncelli.dkmpsample.shared.viewmodel.Navigation

@Composable
fun Navigation.HandleBackButton() {
    BackHandler { // catching the back button to update the DKMPViewModel
        exitScreen()
    }
}