package com.fieldontrack.kmm.android.composables.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.fieldontrack.kmm.android.composables.screens.countrieslist.CountriesListScreen
import com.fieldontrack.kmm.android.composables.screens.countrieslist.CountriesListTwoPaneDefaultDetail
import com.fieldontrack.kmm.android.composables.screens.countrydetail.CountryDetailScreen
import com.fieldontrack.kmm.feature.core.Navigation
import com.fieldontrack.kmm.feature.core.ScreenIdentifier
import com.fieldontrack.kmm.navigation.ScreenImpl.CountriesList
import com.fieldontrack.kmm.navigation.ScreenImpl.CountryDetail
import com.fieldontrack.kmm.feature.sample.countrieslist.selectFavorite
import com.fieldontrack.kmm.feature.sample.countrydetail.CountryDetailParams


@Composable
fun Navigation.ScreenPicker(
    screenIdentifier: ScreenIdentifier
) {

    when (screenIdentifier.screen) {

        CountriesList ->
            CountriesListScreen(
                countriesListState = stateProvider.get(screenIdentifier),
                onListItemClick = {
                    navigate(
                        CountryDetail,
                        CountryDetailParams(countryName = it)
                    )
                },
                onFavoriteIconClick = { events.selectFavorite(countryName = it) },
            )

        CountryDetail ->
            CountryDetailScreen(
                countryDetailState = stateProvider.get(screenIdentifier)
            )

    }

}


@Composable
fun Navigation.TwoPaneDefaultDetail(
    screenIdentifier: ScreenIdentifier
) {

    when (screenIdentifier.screen) {

        CountriesList ->
            CountriesListTwoPaneDefaultDetail()

        else -> Box {}
    }

}