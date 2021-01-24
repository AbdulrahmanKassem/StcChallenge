package com.example.stcchallenge.utils

import android.content.Context
import android.util.TypedValue
import android.view.View
import android.widget.*
import androidx.constraintlayout.solver.state.Dimension
import androidx.core.content.ContextCompat
import java.util.*

fun View.compatColor(colorSource: Int): Int {
    return ContextCompat.getColor(this.context, colorSource)
}