package com.chihhsu.parking

import android.app.Application
import com.chihhsu.parking.data.viewModelModule
import org.koin.core.context.startKoin

class ParkingApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(viewModelModule)
        }
    }
}