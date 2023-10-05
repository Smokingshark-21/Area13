package com.example.area13abschluss.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.area13abschluss.DB.data.Buchung
import com.example.area13abschluss.DB.getDatabase
import kotlinx.coroutines.launch

class Viewmodel(application: Application):AndroidViewModel(application) {

    val database = getDatabase(application)

    val data = database.buchungDao.getAll()


    fun instertbuchung(buchung:Buchung){
        viewModelScope.launch {
            database.buchungDao.Insertall(buchung)
        }
    }
}