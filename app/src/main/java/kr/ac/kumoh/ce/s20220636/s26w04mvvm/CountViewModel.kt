package kr.ac.kumoh.ce.s20220636.s26w04mvvm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private var _counter by mutableStateOf(CounterModel(0))
    val counter: CounterModel
        get() = _counter

    fun incrementCount() {
        _counter = _counter.increment()
    }

    fun decrementCount() {
        _counter = _counter.decrement()
    }

    fun resetCount() {
        _counter = _counter.reset()
    }
}