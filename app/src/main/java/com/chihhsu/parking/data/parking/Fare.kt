package com.chihhsu.parking.data.parking

import com.squareup.moshi.Json

data class Fare(
    @Json(name = "Period") val period: String,
    @Json(name = "Fare") val fare: String,
)
