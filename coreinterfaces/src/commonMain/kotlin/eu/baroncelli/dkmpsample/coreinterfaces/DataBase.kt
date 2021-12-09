package eu.baroncelli.dkmpsample.coreinterfaces

import eu.baroncelli.dkmpsample.shared.datalayer.objects.CountryListData

interface DataBase : CountriesRecords {
}

interface CountriesRecords {
    fun getCountriesList(): List<CountryListData>

    fun setCountriesList(list: List<CountryListData>)

    fun toggleFavoriteCountry(country: String)

    fun getFavoriteCountriesMap(): Map<String, Boolean>
}