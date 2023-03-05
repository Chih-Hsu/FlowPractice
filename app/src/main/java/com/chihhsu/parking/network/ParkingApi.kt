package com.chihhsu.parking.network

import com.chihhsu.parking.data.available.AvailableResult
import com.chihhsu.parking.data.parking.ParkingLotsResult
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://tcgbusfs.blob.core.windows.net/blobtcmsv/"

private val moshi = Moshi.Builder()
    .addLast(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(
        HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    )
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

interface ParkingService {

    @GET("TCMSV_alldesc.json")
    suspend fun getAllParkingLots(): ParkingLotsResult

    @GET("TCMSV_allavailable.json")
    suspend fun getAvailableParkingLots(): AvailableResult
}

object ParkingApi {
    val retrofitService: ParkingService by lazy { retrofit.create(ParkingService::class.java) }
}