package com.fieldontrack.kmm.persistence.localdb.countries

import com.fieldontrack.kmm.entities.countries.CountryExtraData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryExtraDataDB(
    @SerialName("v") val vaccines: String = "",
)

fun CountryExtraData.toDB() = CountryExtraDataDB(vaccines = vaccines)

fun CountryExtraDataDB.toData() = CountryExtraData(vaccines = vaccines)
