package com.chihhsu.parking.data.parking

import com.squareup.moshi.Json

data class EntranceCoordInfo(
    @Json(name = "Xcod") val xCod: String,
    @Json(name = "Ycod") val yCod: String,
    @Json(name = "Address") val address: String
)
