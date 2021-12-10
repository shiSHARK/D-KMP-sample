package com.fieldontrack.kmm.network.webservices.apis

import com.fieldontrack.kmm.common.CountryExtraResponse
import com.fieldontrack.kmm.network.webservices.ApiClient
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

suspend fun ApiClient.fetchCountryExtraDataAPI(country: String): CountryExtraResponseAPI? {
    return getResponse("/dkmpd/" + country.replace(" ", "_"))
}

@Serializable
data class CountryExtraResponseAPI(
    @SerialName("data") val data: CountryExtraAPIData,
    @SerialName("err") val error: String? = null,
)


fun CountryExtraResponseAPI.toData() = CountryExtraResponse(
    data = data.toData(),
    error = error
)
