package com.fieldontrack.kmm.shared.viewmodel

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import com.fieldontrack.kmm.feature.core.DKMPViewModel
import com.fieldontrack.kmm.feature.core.ScreenIdentifier
import com.fieldontrack.kmm.shared.getTestRepository
import com.fieldontrack.kmm.navigation.ScreenImpl.CountriesList
import com.fieldontrack.kmm.navigation.ScreenImpl.CountryDetail
import com.fieldontrack.kmm.feature.sample.countrieslist.CountriesListParams
import com.fieldontrack.kmm.feature.sample.countrieslist.CountriesListState
import com.fieldontrack.kmm.feature.sample.countrieslist.CountriesListType
import com.fieldontrack.kmm.feature.sample.countrydetail.CountryDetailParams
import com.fieldontrack.kmm.feature.sample.countrydetail.CountryDetailState
import com.fieldontrack.kmm.feature.sample.countrydetail.CountryInfo
import com.fieldontrack.kmm.navigation.navigationSettings
import kotlin.test.Test
import kotlin.test.assertTrue

class ViewModelTests {

    val vm = DKMPViewModel(getTestRepository(), navigationSettings)
    val navigation = vm.navigation
    val stateProvider = navigation.stateProvider
    val stateManager = navigation.stateManager


    @Test
    fun testCountriesListStateUpdate() {
        val screenIdentifier =
            ScreenIdentifier.get(CountriesList, CountriesListParams(CountriesListType.ALL))
        val screenInitSettings = screenIdentifier.getScreenInitSettings(navigation)
        stateManager.addScreen(screenIdentifier, screenInitSettings)
        stateManager.updateScreen(CountriesListState::class) {
            it.copy(favoriteCountries = mapOf("Italy" to true))
        }
        val screenState = stateProvider.get(screenIdentifier) as CountriesListState
        assertTrue(screenState.favoriteCountries.containsKey("Italy"))
    }

    @Test
    fun testCountryDetailStateUpdate() {
        val screenIdentifier = ScreenIdentifier.get(CountryDetail, CountryDetailParams("Germany"))
        val screenInitSettings = screenIdentifier.getScreenInitSettings(navigation)
        stateManager.addScreen(screenIdentifier, screenInitSettings)
        stateManager.updateScreen(CountryDetailState::class) {
            it.copy(countryInfo = CountryInfo(_extraData = CountryExtraData(vaccines = "Pfizer, Moderna, AstraZeneca")))
        }
        val screenState = stateProvider.get(screenIdentifier) as CountryDetailState
        assertTrue(screenState.countryInfo.vaccinesList!!.contains("Pfizer"))
    }

}
