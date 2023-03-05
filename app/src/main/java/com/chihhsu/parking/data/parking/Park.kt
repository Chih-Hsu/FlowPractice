package com.chihhsu.parking.data.parking

import com.squareup.moshi.Json

data class Park(
    val id: String,
    val area: String,
    val name: String,
    val type: String,
    val type2: String?,
    val summary: String,
    val address: String,
    val tel: String,
    @Json(name = "payex") val payEx: String,
    val serviceTime: String,
    val tw97x: String,
    val tw97y: String,
    @Json(name = "totalcar") val totalCar: Int,
    @Json(name = "totalmotor") val totalMotor: Int,
    @Json(name = "totalbike") val totalBike: Int,
    @Json(name = "totalbus") val totalBus: Int,
    @Json(name = "Pregnancy_First") val pregnancyFirst: String?,
    @Json(name = "Handicap_First") val handicapFirst: String?,
    @Json(name = "Taxi_OneHR_Free") val taxiOneHRFree: String?,
    @Json(name = "AED_Equipment") val AEDEquipment: String?,
    @Json(name = "CellSignal_Enhancement") val cellSignalEnhancement: String?,
    @Json(name = "Accessibility_Elevator") val accessibilityElevator: String?,
    @Json(name = "Phone_Charge") val phoneCharge: String?,
    @Json(name = "Child_Pickup_Area") val childPickUpArea: String?,
    @Json(name = "FareInfo") val fareInfo: FareInfo,
    @Json(name = "EntranceCoord") val entranceCoord: EntranceCoord
)
