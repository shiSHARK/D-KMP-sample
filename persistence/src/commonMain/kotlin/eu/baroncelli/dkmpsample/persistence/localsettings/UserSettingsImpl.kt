package com.fieldontrack.kmm.shared.datalayer.sources.localsettings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.long
import com.russhwolf.settings.string
import com.fieldontrack.kmm.coreinterfaces.UserSettings

class UserSettingsImpl(s: Settings = Settings()) : UserSettings {


    // here we define all our local settings properties,
    // by using the MultiplatformSettings library delegated properties

    override var listCacheTimestamp by s.long(defaultValue = 0)
    override var savedLevel1URI by s.string()


}