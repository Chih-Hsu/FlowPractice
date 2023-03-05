package com.chihhsu.parking.data.available

import com.squareup.moshi.Json

data class ScoketStatus(
    @Json(name = "spot_abrv") val spotAbrv: String,
    @Json(name = "spot_status") val spotStatus: String
)
