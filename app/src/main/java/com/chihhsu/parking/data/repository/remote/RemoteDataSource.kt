package com.chihhsu.parking.data.repository.remote

import com.chihhsu.parking.data.ParkingUIModel
import com.chihhsu.parking.data.repository.DataSource
import com.chihhsu.parking.network.ParkingApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow

class RemoteDataSource : DataSource {

    override suspend fun getData(): Flow<List<ParkingUIModel>> {

        var allList = listOf<ParkingUIModel>()
        getAllParkingLots().collectLatest {
            allList = it
        }
        var availableList = listOf<ParkingUIModel>()
        getAvailableParkingLots().collectLatest {
            availableList = it
        }
        val combineList = mutableListOf<ParkingUIModel>()
        allList.forEach { park ->
            val available = availableList.filter { it.id == park.id }
            val newModel = ParkingUIModel(
                park.id,
                park.title,
                park.address,
                park.totalCar,
                if (available.isEmpty()) 0 else available.first().availableCar,
                if (available.isEmpty()) 0 else available.first().charging,
                if (available.isEmpty()) 0 else available.first().standby
            )
            combineList.add(newModel)
        }

        return flow {
            emit(combineList)
        }
    }

    override suspend fun getAllParkingLots(): Flow<List<ParkingUIModel>> {

        return flow {
            val parkingList = mutableListOf<ParkingUIModel>()
            val result = ParkingApi.retrofitService.getAllParkingLots()

            for (park in result.data.park) {
                val newParkingUIModel =
                    ParkingUIModel(park.id, park.name, park.address, park.totalCar, 0, 0, 0)
                parkingList.add(newParkingUIModel)
            }
            emit(parkingList)
        }
    }

    override suspend fun getAvailableParkingLots(): Flow<List<ParkingUIModel>> {

        return flow {
            val parkingList = mutableListOf<ParkingUIModel>()
            val result = ParkingApi.retrofitService.getAvailableParkingLots()

            for (park in result.data.park) {
                val charging = park.chargeStation
                var chargeSum = 0
                var standBySum = 0

                charging?.let {
                    for (station in it.scoketStatusList) {
                        if (station.spotStatus == "待機中") {
                            standBySum++
                        } else {
                            chargeSum++
                        }
                    }
                }
                val newParkingUIModel =
                    ParkingUIModel(park.id, "", "", 0, park.availableCar, chargeSum, standBySum)
                parkingList.add(newParkingUIModel)
            }
            emit(parkingList)
        }
    }
}