package com.fieldontrack.kmm.android.composables.navigation.templates

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.SaveableStateHolder
import com.fieldontrack.kmm.android.composables.navigation.ScreenPicker
import com.fieldontrack.kmm.android.composables.navigation.bars.Level1BottomBar
import com.fieldontrack.kmm.android.composables.navigation.bars.TopBar
import com.fieldontrack.kmm.feature.core.Navigation

@Composable
fun Navigation.OnePane(
    saveableStateHolder: SaveableStateHolder
) {
    Scaffold(
        topBar = { TopBar(getTitle(currentScreenIdentifier)) },
        content = {
            saveableStateHolder.SaveableStateProvider(currentScreenIdentifier.URI) {
                ScreenPicker(currentScreenIdentifier)
            }
        },
        bottomBar = {
            if (currentScreenIdentifier.screen.navigationLevel == 1) Level1BottomBar(
                currentScreenIdentifier
            )
        }
    )
}