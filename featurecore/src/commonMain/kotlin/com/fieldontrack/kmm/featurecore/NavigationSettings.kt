package com.fieldontrack.kmm.featurecore


// CONFIGURATION SETTINGS

//object navigationSettings {
//    val homeScreen = Level1Navigation.AllCountries // the start screen should be specified here
//    val saveLastLevel1Screen = true
//    val alwaysQuitOnHomeScreen = true
//}


interface NavigationSettings {
    val homeScreen: Level1Navigation // the start screen should be specified here
    val saveLastLevel1Screen: Boolean
    val alwaysQuitOnHomeScreen: Boolean
    val level1Navigations: List<Level1Navigation>
    val screens: List<Screen>
}

//// LEVEL 1 NAVIGATION OF THE APP
//
interface Level1Navigation {
    val screenIdentifier: ScreenIdentifier
    val rememberVerticalStack: Boolean
//    AllCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = ALL)), true),
//    FavoriteCountries( ScreenIdentifier.get(CountriesList, CountriesListParams(listType = FAVORITES)), true),
}