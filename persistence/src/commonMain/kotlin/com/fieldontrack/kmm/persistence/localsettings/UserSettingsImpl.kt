package com.fieldontrack.kmm.persistence.localsettings

import com.fieldontrack.kmm.coreinterfaces.UserSettings
import com.russhwolf.settings.Settings
import com.russhwolf.settings.long
import com.russhwolf.settings.string

class UserSettingsImpl(s: Settings = Settings()) : UserSettings {


    // here we define all our local settings properties,
    // by using the MultiplatformSettings library delegated properties

    override var listCacheTimestamp by s.long(defaultValue = 0)
    override var savedLevel1URI by s.string()


}