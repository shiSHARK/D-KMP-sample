package com.fieldontrack.kmm.feature.sample.countrieslist

import com.fieldontrack.kmm.feature.core.Events
import com.fieldontrack.kmm.feature.sample.functions.getFavoriteCountriesMap


/********** EVENT functions, called directly by the UI layer **********/

fun Events.selectFavorite(countryName: String) = screenCoroutine {
    val favorites = dataRepository.getFavoriteCountriesMap(alsoToggleCountry = countryName)
    // update state with new favorites map, after toggling the value for the specified country
    stateManager.updateScreen(CountriesListState::class) {
        it.copy(favoriteCountries = favorites)
    }
}
