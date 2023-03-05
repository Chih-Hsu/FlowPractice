package com.chihhsu.parking.data.parking

import com.squareup.moshi.Json

data class FareInfo(
    @Json(name = "WorkingDay") val workingDay: List<Fare>?,
    @Json(name = "Holiday") val holiday: List<Fare>?
)
