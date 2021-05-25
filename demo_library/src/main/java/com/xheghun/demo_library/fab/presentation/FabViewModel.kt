package com.xheghun.demo_library.fab.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import java.util.*

class FabViewModel(context: Context) : ViewModel() {
    private var screenContext : Context

    init {
        screenContext = context
        getInstallDate()
    }

    private var currentTime : Date = Calendar.getInstance().time
    private var dateInstalled : Long = 0

    private fun getInstallDate() {
        dateInstalled = screenContext.packageManager.getPackageInfo(screenContext.packageName, 0).firstInstallTime
    }

}