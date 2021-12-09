package com.fieldontrack.kmm.shared.viewmodel.screens

import com.fieldontrack.kmm.shared.viewmodel.Navigation
import com.fieldontrack.kmm.shared.viewmodel.ScreenIdentifier
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.initCountriesList
import com.fieldontrack.kmm.shared.viewmodel.screens.countrydetail.initCountryDetail


// DEFINITION OF ALL SCREENS IN THE APP

enum class Screen(
    val asString: String,
    val navigationLevel : Int = 1,
    val initSettings: Navigation.(ScreenIdentifier) -> ScreenInitSettings,
    val stackableInstances : Boolean = false,
) {
    CountriesList("countrieslist", 1, { initCountriesList(it.params()) }, true),
    CountryDetail("country", 2, { initCountryDetail(it.params()) }),
}