package com.xheghun.demo_library.fab.data

interface SavedDateInfo {
    fun getInstallDate() : Long?
    fun saveInstallDate(time: Long)
}