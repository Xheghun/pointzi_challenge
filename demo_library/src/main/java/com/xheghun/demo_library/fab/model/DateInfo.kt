package com.xheghun.demo_library.fab.model

import android.content.Context
import com.xheghun.demo_library.fab.data.SavedDateInfoImpl
import java.text.SimpleDateFormat
import java.util.*

class DateInfo(mContext: Context) {

    private val context = mContext
    private val sharedPreferences = context.getSharedPreferences("date_info", Context.MODE_PRIVATE)
    private val savedD = SavedDateInfoImpl(sharedPreferences)

    private fun saveDate() {
        //check if install date have been previously saved
        if (savedD.getInstallDate().compareTo(0) == 0) {
            val installedDate = context.packageManager.getPackageInfo(context.packageName, 0).firstInstallTime
            savedD.saveInstallDate(installedDate)
        }
    }


    fun getInstalledDate(): String {
        saveDate()
        return format(savedD.getInstallDate(), "dd MMM yyyy")
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