package com.podolian.vamatestapp.utils

import kotlinx.coroutines.flow.StateFlow

class StateWrapper<Output>(private val originalFlow: StateFlow<Output>) {
    val sync: StateFlow<Output>
        get() = originalFlow

    val value: Output
        get() = sync.value
}