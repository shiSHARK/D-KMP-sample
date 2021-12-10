package com.fieldontrack.kmm.entities.countries


data class CountryExtraData(
    val vaccines: String = "",
) {
    val vaccinesList: List<String>
        get() = vaccines.split(", ")

}