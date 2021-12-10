package com.fieldontrack.kmm.shared.datalayer.sources.webservices.apis

import com.fieldontrack.kmm.coreinterfaces.CountriesListResponse
import com.fieldontrack.kmm.shared.datalayer.sources.webservices.ApiClient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

suspend fun ApiClient.fetchCountriesListAPI(): CountriesListResponseAPI? {
    return getResponse("/dkmpl/")
}


@Serializable
data class CountriesListResponseAPI(
    @SerialName("data") val data: List<CountryListDataAPI>,
    @SerialName("err") val error: String? = null,
)

fun CountriesListResponseAPI.toData() = CountriesListResponse(
    data = data.map { it.toData() },
    error = error
)