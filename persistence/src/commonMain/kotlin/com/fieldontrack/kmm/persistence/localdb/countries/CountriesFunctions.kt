package com.fieldontrack.kmm.persistence.localdb.countries

import com.fieldontrack.kmm.entities.countries.CountryListData
import mylocal.db.LocalDb

fun LocalDb.getCountriesList(): List<CountryListData> {
    return countriesQueries.getCountriesList(mapper = ::CountryListDataDB).executeAsList()
        .map { it.toData() }
}

fun LocalDb.setCountriesList(list: List<CountryListData>) {
    countriesQueries.transaction {
        list.forEach {
            countriesQueries.upsertCountry(
                name = it.name,
                population = it.population,
                first_doses = it.firstDoses,
                fully_vaccinated = it.fullyVaccinated,
            )
        }
    }
}

fun LocalDb.toggleFavoriteCountry(country: String) {
    countriesQueries.updateFavorite(country)
}

fun LocalDb.getFavoriteCountriesMap(): Map<String, Boolean> {
    return countriesQueries.getFavorites().executeAsList().associateBy({ it }, { true })
}
