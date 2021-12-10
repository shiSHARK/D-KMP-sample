package com.fieldontrack.kmm.coreinterfaces

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import com.fieldontrack.kmm.entities.countries.CountryListData

interface NetworkClient : CountriesClient

interface CountriesClient {
    suspend fun fetchCountriesList(): CountriesListResponse?
    suspend fun fetchCountryExtraData(country: String): CountryExtraResponse?
}

data class CountriesListResponse(
    val data: List<CountryListData>,
    val error: String? = null,
)

data class CountryExtraResponse(
    val data: CountryExtraData,
    val error: String? = null,
)