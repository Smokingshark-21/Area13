package com.example.area13abschluss.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.area13abschluss.DB.getDatabase
import kotlinx.coroutines.launch

class Viewmodel(application: Application):AndroidViewModel(application) {

    val database = getDatabase(application)

    val data = database.buchungDao.getAll()

    fun getDrinks(drink: String){
        viewModelScope.launch {

        }
    }
}