package com.fieldontrack.kmm.android.composables.navigation

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveableStateHolder
import androidx.compose.ui.unit.dp
import com.fieldontrack.kmm.android.composables.navigation.templates.OnePane
import com.fieldontrack.kmm.android.composables.navigation.templates.TwoPane
import com.fieldontrack.kmm.shared.viewmodel.*

@Composable
fun Navigation.Router() {

    val screenUIsStateHolder = rememberSaveableStateHolder()

    val twopaneWidthThreshold = 1000.dp
    BoxWithConstraints() {
        if (maxWidth < maxHeight || maxWidth<twopaneWidthThreshold) {
            OnePane(screenUIsStateHolder)
        } else {
            TwoPane(screenUIsStateHolder)
        }
    }

    screenStatesToRemove.forEach {
        screenUIsStateHolder.removeState(it.URI)
        println("D-KMP: removed UI screen "+it.URI)
    }

    if (!only1ScreenInBackstack) {
        HandleBackButton()
    }

}