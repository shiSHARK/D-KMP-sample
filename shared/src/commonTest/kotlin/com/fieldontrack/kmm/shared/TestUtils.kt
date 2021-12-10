package com.fieldontrack.kmm.shared

import com.fieldontrack.kmm.featurecore.Repository
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.CoroutineContext

expect fun runBlockingTest(block: suspend CoroutineScope.()-> Unit)
expect val testCoroutineContext: CoroutineContext

expect fun getTestRepository() : Repository