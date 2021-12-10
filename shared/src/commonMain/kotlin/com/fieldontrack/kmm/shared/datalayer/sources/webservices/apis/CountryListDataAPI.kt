package com.fieldontrack.kmm.shared.datalayer.sources.webservices.apis

import com.fieldontrack.kmm.entities.countries.CountryListData
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CountryListDataAPI(
    @SerialName("n") val name: String = "",
    @SerialName("p") val population: Int = 0,
    @SerialName("fd") val firstDoses: Int = 0,
    @SerialName("fv") val fullyVaccinated: Int = 0,
)

fun CountryListData.toAPI() = CountryListDataAPI(
    name = name,
    population = population,
    firstDoses = firstDoses,
    fullyVaccinated = fullyVaccinated,
)

fun CountryListDataAPI.toData() = CountryListData(
    name = name,
    population = population,
    firstDoses = firstDoses,
    fullyVaccinated = fullyVaccinated,
)
