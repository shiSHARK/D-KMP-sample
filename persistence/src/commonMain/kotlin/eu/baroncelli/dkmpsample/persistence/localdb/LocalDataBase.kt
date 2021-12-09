package eu.baroncelli.dkmpsample.persistence.localdb

import eu.baroncelli.dkmpsample.coreinterfaces.DataBase
import eu.baroncelli.dkmpsample.shared.datalayer.objects.CountryListData
import mylocal.db.LocalDb

class LocalDataBase(private val localDb: LocalDb) : DataBase {
    override fun getCountriesList(): List<CountryListData> {
        return localDb.countriesQueries.getCountriesList(mapper = ::CountryListData).executeAsList()
    }

    override fun setCountriesList(list: List<CountryListData>) {
        localDb.countriesQueries.transaction {
            list.forEach {
                localDb.countriesQueries.upsertCountry(
                    name = it.name,
                    population = it.population,
                    first_doses = it.firstDoses,
                    fully_vaccinated = it.fullyVaccinated,
                )
            }
        }
    }

    override fun toggleFavoriteCountry(country: String) {
        localDb.countriesQueries.updateFavorite(country)
    }

    override fun getFavoriteCountriesMap(): Map<String, Boolean> {
        return localDb.countriesQueries.getFavorites().executeAsList().associateBy({ it }, { true })
    }
}
