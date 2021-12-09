package com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist

import com.fieldontrack.kmm.shared.datalayer.objects.CountryListData
import com.fieldontrack.kmm.shared.viewmodel.*
import com.fieldontrack.kmm.shared.viewmodel.utils.toPercentageString
import kotlinx.serialization.Serializable

// here is the data class defining the state for this screen

data class CountriesListState (
    val isLoading : Boolean = false,
    val countriesListItems : List<CountriesListItem> = emptyList(),
    val favoriteCountries : Map<String,Boolean> = emptyMap(),
): ScreenState

/********** property classes **********/

enum class CountriesListType { ALL, FAVORITES }

data class CountriesListItem (
    val _data : CountryListData,
) {
    // in the ViewModel classes, our computed properties only do UI-formatting operations
    // (the arithmetical operations, such as calculating a percentage, should happen in the DataLayer classes)
    val name = _data.name
    val firstDosesPerc = _data.firstDosesPercentageFloat.toPercentageString()
    val fullyVaccinatedPerc = _data.fullyVaccinatedPercentageFloat.toPercentageString()
}