package com.chihhsu.parking.data.parking

import com.squareup.moshi.Json

data class EntranceCoord(
    @Json(name = "EntrancecoordInfo") val entranceCoordInfo: List<EntranceCoordInfo>?
)
