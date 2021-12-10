package com.fieldontrack.kmm.shared

import kotlin.native.concurrent.ThreadLocal

@ThreadLocal
val debugLogger by lazy { DebugLogger("D-KMP SAMPLE") }

expect class DebugLogger (tagString : String) {
    val tag : String
    fun log(message: String)
}