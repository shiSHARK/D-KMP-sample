package com.fieldontrack.kmm.shared.viewmodel

import com.fieldontrack.kmm.shared.datalayer.objects.CountryExtraData
import com.fieldontrack.kmm.shared.getTestRepository
import com.fieldontrack.kmm.shared.viewmodel.screens.Screen.*
import com.fieldontrack.kmm.shared.viewmodel.screens.countrydetail.CountryDetailState
import com.fieldontrack.kmm.shared.viewmodel.screens.countrieslist.*
import com.fieldontrack.kmm.shared.viewmodel.screens.countrydetail.CountryDetailParams
import com.fieldontrack.kmm.shared.viewmodel.screens.countrydetail.CountryInfo
import kotlin.test.Test
import kotlin.test.assertTrue

class ViewModelTests {

    val vm = DKMPViewModel(getTestRepository())
    val navigation = vm.navigation
    val stateProvider = navigation.stateProvider
    val stateManager = navigation.stateManager


    @Test
    fun testCountriesListStateUpdate() {
        val screenIdentifier = ScreenIdentifier.get(CountriesList,CountriesListParams(CountriesListType.ALL))
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
