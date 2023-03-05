package com.chihhsu.parking.data.available

import com.squareup.moshi.Json

data class AvailableInfo(
    @Json(name = "UPDATETIME") val updateTime: String,
    val park: List<AvailablePark>
)
