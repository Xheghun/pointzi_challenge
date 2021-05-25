package com.xheghun.demo_library.fab.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FabViewModel(application: Application) : AndroidViewModel(application) {
    private val currentTime: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            DateInfo().getCurrentTime()
        }
    }

    private val dateInstalled: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            DateInfo().getInstalledDate(application)
        }
    }

    fun getDateInstalled() : LiveData<String> {
        return dateInstalled
    }

    fun getCurrentTime() : LiveData<String> {
        return currentTime
    }


}