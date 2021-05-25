package com.xheghun.demo_library.fab.presentation

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.xheghun.demo_library.R

class CustomDialog(mContext: Context, mActivity: Activity) : DialogFragment() {

    private var context: Context = mContext;
    private var activity: Activity = mActivity

    private var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)
    private var dialogLayout: View =
        LayoutInflater.from(context).inflate(R.layout.dialog_layout, null, false)

    private lateinit var alertDialog: AlertDialog


    fun show() {
        pumpData()
        dialogBuilder.setView(dialogLayout)
        alertDialog = dialogBuilder.create()
        setLayoutSize()
        alertDialog.show()
    }

    private fun pumpData() {

        //load image with glide
        val imageTarget = dialogLayout.findViewById<ImageView>(R.id.circleImageView)
        Glide.with(context).load(R.drawable.image).into(imageTarget)

        //display time
        val installedTimeText = dialogLayout.findViewById<TextView>(R.id.installed_time)
        val currentTimeText = dialogLayout.findViewById<TextView>(R.id.current_time_text)

        val time = DateInfo().getInstalledDate(context)
        val res = context.resources

        installedTimeText.text = String.format(res.getString(R.string.library_installed), time)
        currentTimeText.text = DateInfo().getCurrentTime()
    }

    private fun setLayoutSize() {
        val window = alertDialog.window
        window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        window?.setGravity(Gravity.CENTER)
    }
}