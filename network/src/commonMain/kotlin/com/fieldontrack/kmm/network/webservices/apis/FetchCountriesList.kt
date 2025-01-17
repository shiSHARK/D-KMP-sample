package com.fieldontrack.kmm.network.webservices.apis

import com.fieldontrack.kmm.common.CountriesListResponse
import com.fieldontrack.kmm.network.webservices.ApiClient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

suspend fun ApiClient.fetchCountriesListAPI(): CountriesListResponseAPI? {
    return getResponse("/dkmpl/")
}


@Serializable
data class CountriesListResponseAPI(
    @SerialName("data") val data: List<CountryListAPIData>,
    @SerialName("err") val error: String? = null,
)

fun CountriesListResponseAPI.toData() = CountriesListResponse(
    data = data.map { it.toData() },
    error = error
)