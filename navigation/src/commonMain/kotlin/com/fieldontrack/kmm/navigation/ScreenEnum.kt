package com.fieldontrack.kmm.navigation

import com.fieldontrack.kmm.feature.core.Navigation
import com.fieldontrack.kmm.feature.core.Screen
import com.fieldontrack.kmm.feature.core.ScreenIdentifier
import com.fieldontrack.kmm.feature.core.ScreenInitSettings
import com.fieldontrack.kmm.feature.sample.countrieslist.initCountriesList
import com.fieldontrack.kmm.feature.sample.countrydetail.initCountryDetail


// DEFINITION OF ALL SCREENS IN THE APP

enum class ScreenImpl(
    override val asString: String,
    override val navigationLevel: Int = 1,
    override val initSettings: Navigation.(ScreenIdentifier) -> ScreenInitSettings,
    override val stackableInstances: Boolean = false,
) : Screen {
    CountriesList("countrieslist", 1, { initCountriesList(it.params()) }, true),
    CountryDetail("country", 2, { initCountryDetail(it.params()) }),
}

