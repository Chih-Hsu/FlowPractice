package com.chihhsu.parking.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

fun <T> Fragment.collectFlowWithLifeCycle(flow: Flow<T>, collect: (T) -> Unit) {
    lifecycleScope.launchWhenStarted {
        flow.collect(collect)
    }
}