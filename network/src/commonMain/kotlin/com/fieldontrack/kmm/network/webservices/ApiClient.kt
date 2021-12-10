package com.fieldontrack.kmm.network.webservices

import com.fieldontrack.kmm.common.CountriesListResponse
import com.fieldontrack.kmm.common.CountryExtraResponse
import com.fieldontrack.kmm.common.NetworkClient
import com.fieldontrack.kmm.network.webservices.apis.fetchCountriesListAPI
import com.fieldontrack.kmm.network.webservices.apis.fetchCountryExtraDataAPI
import com.fieldontrack.kmm.network.webservices.apis.toData
import io.ktor.client.*
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.serialization.json.Json

class ApiClient : NetworkClient {

    val baseUrl = "https://covidvax.org"

    val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                useAlternativeNames = false // currently needed as a workaround for this bug:
                // https://github.com/Kotlin/kotlinx.serialization/issues/1450#issuecomment-841214332
                // it should get fixed in kotlinx-serialization-json:1.2.2
                ignoreUnknownKeys = true
            })
        }
        /* Ktor specific logging: reenable if needed to debug requests
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        */
    }


    suspend inline fun <reified T : Any> getResponse(endpoint: String): T? {
        val url = baseUrl + endpoint
        try {
            // please notice, Ktor Client is switching to a background thread under the hood
            // so the http call doesn't happen on the main thread, even if the coroutine has been launched on Dispatchers.Main
            val resp = client.get<T>(url)
//            debugLogger.log("$url API SUCCESS")
            return resp
        } catch (e: Exception) {
//            debugLogger.log("$url API FAILED: " + e.message)
        }
        return null
    }


    override suspend fun fetchCountriesList(): CountriesListResponse? =
        fetchCountriesListAPI()?.toData()

    override suspend fun fetchCountryExtraData(country: String): CountryExtraResponse? =
        fetchCountryExtraDataAPI(country)?.toData()

}
