package com.fieldontrack.kmm.feature.sample.countrydetail

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import com.fieldontrack.kmm.entities.countries.CountryListData
import com.fieldontrack.kmm.feature.core.ScreenState
import com.fieldontrack.kmm.feature.sample.utils.toCommaThousandString
import com.fieldontrack.kmm.feature.sample.utils.toPercentageString

// here is the data class defining the state for this screen

data class CountryDetailState(
    val isLoading: Boolean = false,
    val countryInfo: CountryInfo = CountryInfo(),
) : ScreenState


/********** property classes **********/

data class CountryInfo(
    val _listData: CountryListData = CountryListData(),
    val _extraData: CountryExtraData? = CountryExtraData(),
) {
    // in the ViewModel classes, our computed properties only do UI-formatting operations
    // (the arithmetical operations, such as calculating a percentage, should happen in the DataLayer classes)
    val population = _listData.population.toCommaThousandString()
    val firstDoses = _listData.firstDoses.toCommaThousandString()
    val firstDosesPerc = _listData.firstDosesPercentageFloat.toPercentageString()
    val fullyVaccinated = _listData.fullyVaccinated.toCommaThousandString()
    val fullyVaccinatedPerc = _listData.fullyVaccinatedPercentageFloat.toPercentageString()
    val vaccinesList: List<String>? = _extraData?.vaccinesList
}
