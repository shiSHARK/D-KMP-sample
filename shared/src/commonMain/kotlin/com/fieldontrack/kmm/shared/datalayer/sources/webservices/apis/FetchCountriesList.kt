package com.fieldontrack.kmm.shared.datalayer.sources.webservices.apis

import com.fieldontrack.kmm.shared.datalayer.objects.CountryListData
import com.fieldontrack.kmm.shared.datalayer.sources.webservices.ApiClient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

suspend fun ApiClient.fetchCountriesList(): CountriesListResponse? {
    return getResponse("/dkmpl/")
}


@Serializable
data class CountriesListResponse(
    @SerialName("data") val data : List<CountryListData>,
    @SerialName("err") val error : String? = null,
)