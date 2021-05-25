package com.xheghun.demo_library.fab.data

interface SavedDateInfo {
    fun getInstallDate() : String
    fun saveInstallDate(time: Long)
}