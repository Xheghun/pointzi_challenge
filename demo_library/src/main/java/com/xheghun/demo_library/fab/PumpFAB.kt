package com.xheghun.demo_library.fab

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xheghun.demo_library.R
import com.xheghun.demo_library.fab.presentation.CustomDialog

class PumpFAB(act: Activity) {
    private var activity: Activity = act

    fun pumpFAB(context: Context, layoutId: Int) {
        val fab = FloatingActionButton(context)
        fab.id = View.generateViewId()
        val layout = activity.findViewById<ViewGroup>(layoutId)
        fab.setImageResource(R.drawable.ic_add)
        layout.addView(fab)
        alignFAB(layout, fab)


        fab.setOnClickListener {
            CustomDialog().showDialog(context, activity)
        }
    }

    private fun alignFAB(layout: ViewGroup, fab: View) {
        if (layout is ConstraintLayout) {
            val set = ConstraintSet()
            set.clone(layout)
            set.connect(fab.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
            set.connect(fab.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            set.setMargin(fab.id, ConstraintSet.BOTTOM, 15)
            set.setMargin(fab.id, ConstraintSet.RIGHT, 15)
            set.applyTo(layout);
        }
    }
}