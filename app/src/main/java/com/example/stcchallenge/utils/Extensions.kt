package com.example.stcchallenge.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.constraintlayout.solver.state.Dimension
import androidx.core.content.ContextCompat
import java.util.*


fun View.getSizeInDP(size: Float): Int = getSystemSize(context, size).toInt()

fun View.getSizeInDPAsFloat(size: Float): Float = getSystemSize(context, size)

fun getSystemSize(context: Context, size: Float) =
    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, size, context.resources.displayMetrics)

fun View.compatColor(colorSource: Int): Int {
    return ContextCompat.getColor(this.context, colorSource)
}

fun <T : Any> Any?.cast(): T? {
    return this as? T
}