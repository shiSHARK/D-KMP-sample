package com.fieldontrack.kmm.feature.core

//import com.fieldontrack.kmm.shared.DebugLogger
import kotlinx.coroutines.flow.StateFlow

//@ThreadLocal
//val debugLogger by lazy { DebugLogger("FOT KMM") }


class DKMPViewModel(repo: Repository, navigationSettings: NavigationSettings) {

    companion object Factory {
        // factory methods are defined in the platform-specific shared code (androidMain and iosMain)
    }

    val stateFlow: StateFlow<AppState>
        get() = stateManager.mutableStateFlow

    private val stateManager by lazy { StateManager(repo, navigationSettings) }
    val navigation by lazy { Navigation(stateManager, navigationSettings) }

}