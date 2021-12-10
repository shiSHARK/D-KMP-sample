package com.fieldontrack.kmm.feature.core


// DEFINITION OF ALL SCREENS IN THE APP

interface Screen {
    val asString: String
    val navigationLevel: Int
    val initSettings: Navigation.(ScreenIdentifier) -> ScreenInitSettings
    val stackableInstances: Boolean
}

