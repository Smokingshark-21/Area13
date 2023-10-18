package com.example.area13abschluss.Wetter.Data.model

import com.squareup.moshi.Json

class Weater (
    @Json(name = "city_name"      ) var cityName     : String,
    @Json(name ="temp"           ) var temp         : Double,
    @Json(name ="wind_dir"       ) var windDir      : Double,
    @Json(name ="wind_spd"       ) var windSpd      : Double,

    )
