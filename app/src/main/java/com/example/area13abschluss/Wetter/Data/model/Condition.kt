package com.example.area13abschluss.Wetter.Data.model

import com.squareup.moshi.Json

data class Condition(
    @Json(name = "text" ) var text : String? = null,
    @Json(name = "icon" ) var icon : String? = null,
)

