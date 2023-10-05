package com.example.area13abschluss.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.area13abschluss.DB.data.Buchung

@Database(entities = [Buchung::class], version = 1)
abstract class DatenDataBase : RoomDatabase() {

    abstract val buchungDao:BuchungDao

}


private lateinit var INSTANCE: DatenDataBase

fun getDatabase(context: Context): DatenDataBase {
    synchronized(DatenDataBase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                DatenDataBase::class.java,
                "buchung_table"
            )
                .allowMainThreadQueries().build()
        }
    }
    return INSTANCE

}