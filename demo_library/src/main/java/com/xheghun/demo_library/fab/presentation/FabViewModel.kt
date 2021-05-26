package com.xheghun.demo_library.fab.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.xheghun.demo_library.fab.model.DateInfo

class FabViewModel(application: Application) : AndroidViewModel(application) {

    private val dateInfo = DateInfo(application)

    private val currentTime: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            dateInfo.getCurrentTime()
        }
    }

    private val dateInstalled: MutableLiveData<String> by lazy {
        MutableLiveData<String>().also {
            dateInfo.getInstalledDate()
        }
    }

    fun getDateInstalled() : LiveData<String> {
        return dateInstalled
    }

    fun getCurrentTime() : LiveData<String> {
        return currentTime
    }


}