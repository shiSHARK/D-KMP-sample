package com.fieldontrack.kmm.coreinterfaces

import com.fieldontrack.kmm.entities.countries.CountryListData

interface DataBase : CountriesRecords {
}

interface CountriesRecords {
    fun getCountriesList(): List<CountryListData>

    fun setCountriesList(list: List<CountryListData>)

    fun toggleFavoriteCountry(country: String)

    fun getFavoriteCountriesMap(): Map<String, Boolean>
}