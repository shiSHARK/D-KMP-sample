package com.fieldontrack.kmm.shared.viewmodel.screens.countrydetail

import com.fieldontrack.kmm.feature.core.Navigation
import com.fieldontrack.kmm.feature.core.ScreenInitSettings
import com.fieldontrack.kmm.feature.core.ScreenParams
import com.fieldontrack.kmm.shared.datalayer.functions.getCountryInfo
import kotlinx.serialization.Serializable


// INIZIALIZATION settings for this screen
// to understand the initialization behaviour, read the comments in the ScreenInitSettings.kt file

@Serializable // Note: ScreenParams should always be set as Serializable
data class CountryDetailParams(val countryName: String) : ScreenParams

fun Navigation.initCountryDetail(params: CountryDetailParams) = ScreenInitSettings(
    title = params.countryName,
    initState = { CountryDetailState(isLoading = true) },
    callOnInit = {
        val countryInfo = dataRepository.getCountryInfo(params.countryName)
        // update state, after retrieving data from the repository
        stateManager.updateScreen(CountryDetailState::class) {
            it.copy(
                isLoading = false,
                countryInfo = countryInfo,
            )
        }
    }
)