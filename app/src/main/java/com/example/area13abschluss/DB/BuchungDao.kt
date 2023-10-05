package com.example.area13abschluss.DB

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.area13abschluss.DB.data.Buchung

@Dao
interface BuchungDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun Insertall(buchunglist:Buchung)

    @Update
    suspend fun ubdate(Buchung: Buchung)

    @Query("SELECT * FROM Buchung")
    fun getAll(): LiveData<List<Buchung>>


    @Query("DELETE FROM Buchung")
    fun dellAll()

    @Query("SELECT* FROM Buchung WHERE idbuchung= :id")
    fun getBuchung(id:Int):Buchung

}