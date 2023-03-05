package com.chihhsu.parking.data.repository

import com.chihhsu.parking.data.ParkingUIModel
import com.chihhsu.parking.data.available.AvailableResult
import com.chihhsu.parking.data.parking.ParkingLotsResult
import kotlinx.coroutines.flow.Flow

interface DataSource {

    suspend fun getData(): Flow<List<ParkingUIModel>>
    suspend fun getAllParkingLots(): Flow<List<ParkingUIModel>>
    suspend fun getAvailableParkingLots(): Flow<List<ParkingUIModel>>
}