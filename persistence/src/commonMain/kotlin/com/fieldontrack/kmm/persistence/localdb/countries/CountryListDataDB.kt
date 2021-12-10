package com.fieldontrack.kmm.persistence.localdb.countries

import com.fieldontrack.kmm.entities.countries.CountryListData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryListDataDB(
    @SerialName("n") val name: String = "",
    @SerialName("p") val population: Int = 0,
    @SerialName("fd") val firstDoses: Int = 0,
    @SerialName("fv") val fullyVaccinated: Int = 0,
)

fun CountryListData.toDB() = CountryListDataDB(
    name = name,
    population = population,
    firstDoses = firstDoses,
    fullyVaccinated = fullyVaccinated,
)

fun CountryListDataDB.toData() = CountryListData(
    name = name,
    population = population,
    firstDoses = firstDoses,
    fullyVaccinated = fullyVaccinated,
)
