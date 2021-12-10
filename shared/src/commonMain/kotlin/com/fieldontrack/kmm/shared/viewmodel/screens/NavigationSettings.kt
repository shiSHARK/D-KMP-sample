package com.fieldontrack.kmm.shared.viewmodel.screens

import com.fieldontrack.kmm.featurecore.Level1Navigation
import com.fieldontrack.kmm.featurecore.NavigationSettings
import com.fieldontrack.kmm.featurecore.Screen
import com.fieldontrack.kmm.featurecore.ScreenIdentifier
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.CountriesListParams
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.CountriesListType


// CONFIGURATION SETTINGS

object navigationSettings : NavigationSettings {
    override val homeScreen =
        Level1NavigationImpl.AllCountries // the start screen should be specified here
    override val saveLastLevel1Screen = true
    override val alwaysQuitOnHomeScreen = true
    override val level1Navigations = Level1NavigationImpl.values().toList()
    override val screens: List<Screen> = ScreenImpl.values().toList()
}


// LEVEL 1 NAVIGATION OF THE APP

enum class Level1NavigationImpl(
    override val screenIdentifier: ScreenIdentifier,
    override val rememberVerticalStack: Boolean = false
) :
    Level1Navigation {
    AllCountries(
        ScreenIdentifier.get(
            ScreenImpl.CountriesList,
            CountriesListParams(listType = CountriesListType.ALL)
        ), true
    ),
    FavoriteCountries(
        ScreenIdentifier.get(
            ScreenImpl.CountriesList,
            CountriesListParams(listType = CountriesListType.FAVORITES)
        ), true
    ),
}