package com.xheghun.demo_library.fab

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.RelativeLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xheghun.demo_library.R
import com.xheghun.demo_library.fab.presentation.CustomDialog

class FabLibrary(act: Activity,  mLayoutId: Int) {
    private val activity: Activity = act
    private val layoutId = mLayoutId

    private val fab = FloatingActionButton(activity)
    private val layout = activity.findViewById<ViewGroup>(layoutId)

    fun init() {
        fab.id = View.generateViewId()
        fab.setImageResource(R.drawable.ic_add)


        layout.addView(fab)
        alignFAB()
        setFabMargin()
        fab.setOnClickListener {
            CustomDialog(activity).show()
        }
    }

    private fun setFabMargin() {
        val margin = 20
        val layoutParam = fab.layoutParams as ViewGroup.MarginLayoutParams
        layoutParam.setMargins(margin, margin,margin,margin)
        fab.layoutParams = layoutParam
    }

    private fun alignFAB() {
        if (layout is ConstraintLayout) {
            val set = ConstraintSet()
            set.clone(layout)
            set.connect(fab.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
            set.connect(fab.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            set.applyTo(layout)
        } else if (layout is RelativeLayout) {
           val layoutParams =  fab.layoutParams as (LayoutParams)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            fab.layoutParams = layoutParams
        }
    }
}