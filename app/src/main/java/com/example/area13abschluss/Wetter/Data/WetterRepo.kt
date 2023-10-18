package com.example.area13abschluss.Wetter.Data

import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.area13abschluss.Wetter.Data.model.Current
import com.example.area13abschluss.Wetter.WeaterAPI

const val Tag = "AppRepository"

class WetterRepo(private val api:WeaterAPI) {

    private val _weater = MutableLiveData<Current>()
    val weater: LiveData<Current>
        get() = _weater


    suspend fun getWeater(){
        try {
            _weater.value=api.retrofitservice.getWeater().current!!
            Log.e("w","${_weater.value}")
        }catch (e:Exception){
            Log.e(ContentValues.TAG,"Error $e")
        }
    }

}