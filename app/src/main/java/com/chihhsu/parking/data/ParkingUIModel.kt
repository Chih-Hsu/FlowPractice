package com.chihhsu.parking.data

data class ParkingUIModel(
    val id: String,
    val title: String,
    val address: String,
    val totalCar: Int,
    val availableCar: Int,
    val charging: Int?,
    val standby: Int?
)
