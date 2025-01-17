package com.fieldontrack.kmm.android.composables.navigation.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fieldontrack.kmm.feature.core.Navigation
import com.fieldontrack.kmm.feature.core.ScreenIdentifier
import com.fieldontrack.kmm.navigation.Level1NavigationImpl


// this is the left vertical navigation bar for 2-Pane visualization
// (used by bigger devices in landscape mode)

@Composable
fun Navigation.Level1NavigationRail(
    selectedTab: ScreenIdentifier
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(MaterialTheme.colors.primary),
        verticalArrangement = Arrangement.Center
    ) {
        NavigationRailItem(
            icon = { Icon(Icons.Default.Menu, "ALL") },
            label = { Text("All Countries", fontSize = 13.sp) },
            selected = selectedTab.URI == Level1NavigationImpl.AllCountries.screenIdentifier.URI,
            onClick = { navigateByLevel1Menu(Level1NavigationImpl.AllCountries) }
        )
        NavigationRailItem(
            icon = { Icon(Icons.Default.Star, "FAVORITES") },
            label = { Text("Favourites", fontSize = 13.sp) },
            selected = selectedTab.URI == Level1NavigationImpl.FavoriteCountries.screenIdentifier.URI,
            onClick = { navigateByLevel1Menu(Level1NavigationImpl.FavoriteCountries) }
        )
    }
}


@Composable
fun ColumnScope.NavigationRailItem(
    icon: @Composable () -> Unit,
    label: @Composable () -> Unit,
    selected: Boolean,
    onClick: () -> Unit
) {
    CompositionLocalProvider(
        LocalContentColor provides if (selected) MaterialTheme.colors.background else MaterialTheme.colors.primaryVariant
    ) {
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .padding(top = 25.dp, bottom = 25.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                icon()
                label()
            }
        }
    }
}
