package com.xheghun.demo_library.fab.presentation

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.xheghun.demo_library.R

class CustomDialog(mContext: Context) : Dialog(mContext) {
    init {
        setCancelable(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_layout)
        setWindowAttributes()
        pumpData()
    }


    private fun setWindowAttributes() {
        window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
        val layoutParams = window?.attributes
        //set dialog background opacity to 50%
        layoutParams?.dimAmount = 0.5f
        window?.attributes = layoutParams
    }


    private fun pumpData() {
        //load image with glide
        val imageTarget = findViewById<ImageView>(R.id.circleImageView)
        Glide.with(context).load(R.drawable.image).into(imageTarget)

        //display time
        val installedTimeText = findViewById<TextView>(R.id.installed_time)
        val currentTimeText = findViewById<TextView>(R.id.current_time_text)

        val time = DateInfo().getInstalledDate(context)
        val res = context.resources

        installedTimeText.text = String.format(res.getString(R.string.library_installed), time)
        currentTimeText.text = DateInfo().getCurrentTime()
        //continuously update time
        updateCurrentTime(currentTimeText)
    }

   private fun updateCurrentTime(textView: TextView) {
        val  handler = Handler(Looper.getMainLooper())
        handler.post(object : Runnable {
            override fun run() {
                textView.text = DateInfo().getCurrentTime()
                handler.postDelayed(this, 1000)
            }
        })
    }

}