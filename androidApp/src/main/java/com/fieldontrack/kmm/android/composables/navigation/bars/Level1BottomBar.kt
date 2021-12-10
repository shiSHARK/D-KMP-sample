package com.fieldontrack.kmm.android.composables.navigation.bars

import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.fieldontrack.kmm.feature.core.Navigation
import com.fieldontrack.kmm.feature.core.ScreenIdentifier
import com.fieldontrack.kmm.shared.viewmodel.screens.Level1NavigationImpl


// this is the bottom horizontal navigation bar for 1-Pane visualization
// (used by small devices and in Portrait mode)

@Composable
fun Navigation.Level1BottomBar(
    selectedTab: ScreenIdentifier
) {
    BottomAppBar(content = {
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Menu, "ALL") },
            label = { Text("All Countries", fontSize = 13.sp) },
            selected = selectedTab.URI == Level1NavigationImpl.AllCountries.screenIdentifier.URI,
            onClick = { navigateByLevel1Menu(Level1NavigationImpl.AllCountries) }
        )
        BottomNavigationItem(
            icon = { Icon(Icons.Default.Star, "FAVORITES") },
            label = { Text("Favourites", fontSize = 13.sp) },
            selected = selectedTab.URI == Level1NavigationImpl.FavoriteCountries.screenIdentifier.URI,
            onClick = { navigateByLevel1Menu(Level1NavigationImpl.FavoriteCountries) }
        )
    })
}