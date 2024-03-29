package com.example.area13abschluss

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.DB.getDatabase
import com.example.area13abschluss.Wetter.Data.WetterRepo
import com.example.area13abschluss.Wetter.WeaterAPI
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar





class Viewmodel(application: Application):AndroidViewModel(application) {

    val database = getDatabase(application)

    val data = database.buchungDao.getAll()

    fun instertbuchung(buchung:Buchung){
        viewModelScope.launch {
            database.buchungDao.Insertall(buchung)
        }
    }

    fun datum():String{
        val Calendar:Calendar = Calendar.getInstance()
        val selectedDate = SimpleDateFormat("dd.MM.yyyy")
        return selectedDate.format(Calendar.time)
    }

    fun delbuchung(id:Int){
        viewModelScope.launch {
            database.buchungDao.dellBuchung(id)
        }

    }

    val repository = WetterRepo(api = WeaterAPI)

    val current = repository.weater

    fun loadWeater(){
        viewModelScope.launch {
            repository.getWeater()
        }
    }

}