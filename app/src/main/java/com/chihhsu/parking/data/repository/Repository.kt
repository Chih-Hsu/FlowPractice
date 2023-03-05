package com.chihhsu.parking.data.repository

import com.chihhsu.parking.data.ParkingUIModel
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getData(): Flow<List<ParkingUIModel>>
}