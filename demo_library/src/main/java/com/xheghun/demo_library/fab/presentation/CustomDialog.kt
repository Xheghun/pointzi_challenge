package com.xheghun.demo_library.fab.presentation

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.xheghun.demo_library.R

class CustomDialog {
   fun showDialog(context: Context, activity: Activity) {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

        val dialogLayout = LayoutInflater.from(context).inflate(R.layout.dialog_layout, null,false)

       //load image with glide
       val imageTarget = dialogLayout.findViewById<ImageView>(R.id.circleImageView)
       Glide.with(context).load(R.drawable.image).into(imageTarget)

       //display time
       val installedTimeText = dialogLayout.findViewById<TextView>(R.id.installed_time)
       val currentTimeText = dialogLayout.findViewById<TextView>(R.id.current_time_text)

       val time = Cont().getInstalledDate(context)

       val res = context.resources

       installedTimeText.text =  String.format(res.getString(R.string.library_installed), time)
       currentTimeText.text = Cont().getCurrentTime()

        dialogBuilder.setView(dialogLayout)
        val alertDialog: AlertDialog = dialogBuilder.create()
       val window = alertDialog.window
       window?.setLayout(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT)
       window?.setGravity(Gravity.CENTER)
        alertDialog.show()
    }
}