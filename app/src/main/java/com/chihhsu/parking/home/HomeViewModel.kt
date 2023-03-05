package com.chihhsu.parking.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chihhsu.parking.data.ParkingUIModel
import com.chihhsu.parking.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val repository: Repository) : ViewModel() {

    private val _parkingList = MutableStateFlow(emptyList<ParkingUIModel>())
    val parkingList: StateFlow<List<ParkingUIModel>> get() = _parkingList

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    init {
        collectAll()
    }

    private fun collectAll() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            repository.getData()
                .onCompletion { _isLoading.value = false }
                .collectLatest {
                    _parkingList.value = it
                }
        }
    }
}