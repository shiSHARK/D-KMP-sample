package com.fieldontrack.kmm.feature.core

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

typealias URI = String

class ScreenIdentifier private constructor(
    val screen: Screen,
    var params: ScreenParams? = null,
    var paramsAsString: String? = null,
) {

    val URI: URI
        get() = returnURI()

    companion object Factory {
        fun get(screen: Screen, params: ScreenParams?): ScreenIdentifier {
            return ScreenIdentifier(screen, params, null)
        }

        fun getByURI(URI: String, screens: List<Screen>): ScreenIdentifier? {
            val parts = URI.split(":")
            screens.forEach {
                if (it.asString == parts[0]) {
                    return ScreenIdentifier(it, null, parts[1])
                }
            }
            return null
        }

    }

    private fun returnURI(): String {
        if (paramsAsString != null) {
            return screen.asString + ":" + paramsAsString
        }
        val toString = params.toString() // returns `ClassParams(A=1&B=2)`
        val startIndex = toString.indexOf("(")
        val paramsString = toString.substring(startIndex + 1, toString.length - 1)
        return screen.asString + ":" + paramsString
    }

    // unlike the "params" property, this reified function returns the specific type and not the generic "ScreenParams" interface type
    inline fun <reified T : ScreenParams> params(): T {
        if (params == null && paramsAsString != null) {
            val jsonValues = paramsStrToJson(paramsAsString!!)
            params = Json.decodeFromString<T>("""{$jsonValues}""")
        }
        return params as T
    }

    fun paramsStrToJson(paramsAsString: String): String {
        // converts `A=1&B=1` into `"A":"1","B":"2"`
        val elements = paramsAsString.split("&")
        var jsonValues = ""
        elements.forEach {
            if (jsonValues != "") {
                jsonValues += ","
            }
            val parts = it.split("=")
            jsonValues += "\"${parts[0]}\":\"${parts[1]}\""
        }
        return jsonValues
    }


    fun getScreenInitSettings(navigation: Navigation): ScreenInitSettings {
        return screen.initSettings(navigation, this)
    }

    fun level1VerticalBackstackEnabled(level1Navigations: List<Level1Navigation>): Boolean {
        level1Navigations.forEach {
            if (it.screenIdentifier.URI == this.URI && it.rememberVerticalStack) {
                return true
            }
        }
        return false
    }

}