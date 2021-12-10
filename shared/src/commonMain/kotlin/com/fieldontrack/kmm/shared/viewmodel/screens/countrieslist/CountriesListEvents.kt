package com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist

import com.fieldontrack.kmm.shared.datalayer.functions.getFavoriteCountriesMap
import com.fieldontrack.kmm.featurecore.Events


/********** EVENT functions, called directly by the UI layer **********/

fun Events.selectFavorite(countryName: String) = screenCoroutine {
    val favorites = dataRepository.getFavoriteCountriesMap(alsoToggleCountry = countryName)
    // update state with new favorites map, after toggling the value for the specified country
    stateManager.updateScreen(CountriesListState::class) {
        it.copy(favoriteCountries = favorites)
    }
}
