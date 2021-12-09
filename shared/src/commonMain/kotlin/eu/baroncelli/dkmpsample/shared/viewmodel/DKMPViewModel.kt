package com.fieldontrack.kmm.shared.viewmodel

import com.fieldontrack.kmm.shared.DebugLogger
import com.fieldontrack.kmm.shared.datalayer.Repository
import kotlinx.coroutines.flow.StateFlow
import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val debugLogger by lazy { DebugLogger("FOT KMM") }


class DKMPViewModel (repo: Repository) {

    companion object Factory {
        // factory methods are defined in the platform-specific shared code (androidMain and iosMain)
    }

    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow

    private val stateManager by lazy { StateManager(repo) }
    val navigation by lazy { Navigation(stateManager) }

}