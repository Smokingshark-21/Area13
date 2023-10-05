package com.example.area13abschluss.DB.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Buchung(
    @PrimaryKey
    val idbuchung:String,
    val datum:String,
    val uhrzeit:String,
    val ort:String
)
