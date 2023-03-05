package com.chihhsu.parking.data.available

import com.squareup.moshi.Json

data class AvailablePark(
    val id: String,
    @Json(name = "availablecar") val availableCar: Int,
    @Json(name = "availablemotor") val availableMotor: Int,
    @Json(name = "availablebus") val availableBus: Int,
    @Json(name = "ChargeStation") val chargeStation: ChargeStation?
)
