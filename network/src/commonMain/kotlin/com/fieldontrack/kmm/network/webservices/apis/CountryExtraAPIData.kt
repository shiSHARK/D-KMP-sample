package com.fieldontrack.kmm.network.webservices.apis

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryExtraAPIData(
    @SerialName("v") val vaccines: String = "",
)

fun CountryExtraData.toAPI() = CountryExtraAPIData(vaccines = vaccines)

fun CountryExtraAPIData.toData() = CountryExtraData(vaccines = vaccines)
