package com.xheghun.demo_library.fab.presentation

import android.content.Context
import java.text.SimpleDateFormat
import java.util.*

class Cont {



    fun getInstalledDate(context: Context): String {
       val installedDate = context.packageManager.getPackageInfo(context.packageName, 0).firstInstallTime
        return format(installedDate, "dd MMM yyyy")
    }

    fun getCurrentTime() : String {
        val currentTime = System.currentTimeMillis()
        return format(currentTime, "hh:mm:ss dd MMM yyyy")
    }

    private fun format(time: Long, dFormat: String): String {
        val date = Date(time)
        val format = SimpleDateFormat(dFormat)
        return format.format(date)
    }


}