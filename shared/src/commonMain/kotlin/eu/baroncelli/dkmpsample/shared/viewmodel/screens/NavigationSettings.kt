package com.fieldontrack.kmm.shared.viewmodel.screens

import com.fieldontrack.kmm.shared.viewmodel.ScreenIdentifier
import com.fieldontrack.kmm.shared.viewmodel.screens.Screen.*
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.CountriesListParams
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.CountriesListType.*


// CONFIGURATION SETTINGS

object navigationSettings {
    val homeScreen = Level1Navigation.AllCountries // the start screen should be specified here
    val saveLastLevel1Screen = true
    val alwaysQuitOnHomeScreen = true
}


// LEVEL 1 NAVIGATION OF THE APP

enum class Level1Navigation(val screenIdentifier: ScreenIdentifier, val rememberVerticalStack: Boolean = false) {
    AllCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = ALL)), true),
    FavoriteCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = FAVORITES)), true),
}