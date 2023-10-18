package com.example.area13abschluss.Wetter.Data.model

import com.squareup.moshi.Json

data class Current (

    @Json(name = "last_updated_epoch" ) var lastUpdatedEpoch : Int?       = null,
    @Json(name = "last_updated"       ) var lastUpdated      : String?    = null,
    @Json(name = "temp_c"             ) var tempC            : Int?       = null,
    @Json(name = "temp_f"             ) var tempF            : Double?    = null,
    @Json(name = "is_day"             ) var isDay            : Int?       = null,
    @Json(name = "wind_mph"           ) var windMph          : Double?    = null,
    @Json(name = "wind_kph"           ) var windKph          : Double?       = null,
    @Json(name = "wind_degree"        ) var windDegree       : Int?       = null,
    @Json(name = "wind_dir"           ) var windDir          : String?    = null,
    @Json(name = "pressure_mb"        ) var pressureMb       : Int?       = null,
    @Json(name = "pressure_in"        ) var pressureIn       : Double?    = null,
    @Json(name = "precip_mm"          ) var precipMm         : Int?       = null,
    @Json(name = "precip_in"          ) var precipIn         : Int?       = null,
    @Json(name = "humidity"           ) var humidity         : Int?       = null,
    @Json(name = "cloud"              ) var cloud            : Int?       = null,
    @Json(name = "feelslike_c"        ) var feelslikeC       : Double?    = null,
    @Json(name = "feelslike_f"        ) var feelslikeF       : Double?    = null,
    @Json(name = "vis_km"             ) var visKm            : Int?       = null,
    @Json(name = "vis_miles"          ) var visMiles         : Int?       = null,
    @Json(name = "uv"                 ) var uv               : Int?       = null,
    @Json(name = "gust_mph"           ) var gustMph          : Double?    = null,
    @Json(name = "gust_kph"           ) var gustKph          : Double?    = null,
    @Json(name ="condition"          ) var condition        : Condition? = Condition(),
    )
