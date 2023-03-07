package com.chihhsu.parking.data

import com.chihhsu.parking.data.repository.DataSource
import com.chihhsu.parking.data.repository.DefaultRepository
import com.chihhsu.parking.data.repository.Repository
import com.chihhsu.parking.data.repository.remote.RemoteDataSource
import com.chihhsu.parking.home.HomeViewModel
import com.chihhsu.parking.network.ParkingService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val viewModelModule = module {

    viewModel {
        HomeViewModel(get())
    }
    factory<Repository> {
        DefaultRepository(get())
    }
    factory<DataSource> {
        RemoteDataSource(get())
    }
    single {
        val BASE_URL = "https://tcgbusfs.blob.core.windows.net/blobtcmsv/"
        val moshi = Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()

        val client = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
            .build()

        Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .client(client)
            .build()
            .create(ParkingService::class.java)
    }
}