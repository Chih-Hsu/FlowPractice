package com.chihhsu.parking.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.chihhsu.parking.data.repository.Repository
import com.chihhsu.parking.home.HomeViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }
}