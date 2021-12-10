package com.fieldontrack.kmm.shared.datalayer.sources.webservices.apis

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryExtraDataAPI(
    @SerialName("v") val vaccines: String = "",
)

fun CountryExtraData.toAPI() = CountryExtraDataAPI(vaccines = vaccines)

fun CountryExtraDataAPI.toData() = CountryExtraData(vaccines = vaccines)
