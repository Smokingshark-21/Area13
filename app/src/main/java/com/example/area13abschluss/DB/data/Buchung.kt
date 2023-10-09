package com.example.area13abschluss.DB.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Buchung(
    @PrimaryKey(autoGenerate = true)
    val idbuchung: Int,
    val datum:String,
    val uhrzeit:String,
    val ort:String,
    var active:Boolean,
    val vorname:String,
    val nachname:String,
    val email:String,
    val telefonnummer:String
)
