package com.example.area13abschluss.Wetter.Data.model

import com.squareup.moshi.Json

data class Data (

    @Json(name = "current"  ) var current  : Current?  = Current()

)
