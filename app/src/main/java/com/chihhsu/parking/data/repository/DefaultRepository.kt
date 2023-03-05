package com.chihhsu.parking.data.repository

import com.chihhsu.parking.data.ParkingUIModel
import kotlinx.coroutines.flow.Flow

class DefaultRepository(
    private val remoteDataSource: DataSource
) : Repository {

    override suspend fun getData(): Flow<List<ParkingUIModel>> {
        return remoteDataSource.getData()
    }
}