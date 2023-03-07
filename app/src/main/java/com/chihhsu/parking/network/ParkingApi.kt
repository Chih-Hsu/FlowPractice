package com.chihhsu.parking.network

import com.chihhsu.parking.data.available.AvailableResult
import com.chihhsu.parking.data.parking.ParkingLotsResult
import retrofit2.http.GET


interface ParkingService {

    @GET("TCMSV_alldesc.json")
    suspend fun getAllParkingLots(): ParkingLotsResult

    @GET("TCMSV_allavailable.json")
    suspend fun getAvailableParkingLots(): AvailableResult
}
