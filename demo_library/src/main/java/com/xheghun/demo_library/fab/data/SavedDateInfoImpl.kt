package com.xheghun.demo_library.fab.data

import android.content.SharedPreferences

class SavedDateInfoImpl(private val sharedPreferences: SharedPreferences) : SavedDateInfo {
    private val dataKey = "install_date"

    override fun getInstallDate(): Long {
        return sharedPreferences.getLong(dataKey,0)
    }

    override fun saveInstallDate(time: Long) {
        sharedPreferences.edit().putLong(dataKey, time).apply()
    }
}