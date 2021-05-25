package com.xheghun.demo_library.fab.presentation

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.xheghun.demo_library.R

class CustomDialog {
   fun showDialog(context: Context, activity: Activity) {
        val dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

        val parent: ViewGroup = activity.window.decorView.rootView as (ViewGroup)

        val dialogLayout = LayoutInflater.from(context).inflate(R.layout.dialog_layout, parent,false);
        dialogBuilder.setView(dialogLayout)
        val alertDialog: AlertDialog = dialogBuilder.create()
        alertDialog.show()
    }
}