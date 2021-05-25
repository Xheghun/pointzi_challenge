package com.xheghun.pointzi_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.xheghun.demo_library.fab.FabLibrary

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FabLibrary(this,R.id.main_layout).init()
    }
}