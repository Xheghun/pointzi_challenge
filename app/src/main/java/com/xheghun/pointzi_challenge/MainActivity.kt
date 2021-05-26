package com.xheghun.pointzi_challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.xheghun.demo_library.fab.FabLibrary
import com.xheghun.pointzi_challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

//        FabLibrary(this,R.id.main_layout).init()
        val builder = FabLibrary.Builder()
//        builder.setRoot(binding.root as ViewGroup).build()
        builder.setActivityParams(this, R.id.main_layout).build()
    }
}