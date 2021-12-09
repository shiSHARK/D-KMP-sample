package com.fieldontrack.kmm.coreinterfaces

import com.fieldontrack.kmm.shared.datalayer.objects.CountryListData

interface DataBase : CountriesRecords {
}

interface CountriesRecords {
    fun getCountriesList(): List<CountryListData>

    fun setCountriesList(list: List<CountryListData>)

    fun toggleFavoriteCountry(country: String)

    fun getFavoriteCountriesMap(): Map<String, Boolean>
}