package com.xheghun.demo_library.fab

import android.app.Activity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.RelativeLayout.LayoutParams
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.xheghun.demo_library.R
import com.xheghun.demo_library.fab.presentation.CustomDialog

class FabLibrary(private val rootLayout: ViewGroup) {

    private var fab: FloatingActionButton = FloatingActionButton(rootLayout.context)

    class Builder {

        fun setRoot(root: ViewGroup): FabLibrary {
            return FabLibrary(root)
        }

        fun setActivityParams(activity: Activity, layoutId: Int): FabLibrary {
            val root = activity.findViewById<ViewGroup>(layoutId)
            return FabLibrary(root)
        }

    }

    fun build() {
        fab.id = View.generateViewId()
        fab.setImageResource(R.drawable.ic_add)

        rootLayout.addView(fab)

        alignFAB()
        setFabMargin()
        fab.setOnClickListener {
            CustomDialog(rootLayout.context).show()
        }
    }

    private fun setFabMargin() {
        val margin = 20
        val layoutParam = fab.layoutParams as ViewGroup.MarginLayoutParams
        layoutParam.setMargins(margin, margin, margin, margin)
        fab.layoutParams = layoutParam
    }

    private fun alignFAB() {
        if (rootLayout is ConstraintLayout) {
            val rootView = rootLayout as ConstraintLayout
            val set = ConstraintSet()
            set.clone(rootView)
            set.connect(fab.id, ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT)
            set.connect(fab.id, ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM)
            set.applyTo(rootView)
        } else if (rootLayout is RelativeLayout) {
            val layoutParams = fab.layoutParams as (LayoutParams)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT)
            fab.layoutParams = layoutParams
        }
    }
}