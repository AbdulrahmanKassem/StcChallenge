package com.example.stcchallenge.utils

import android.util.Log

object DevPrint {
    fun printError(text: Any?) {
        Log.e("🔴DevPrint💥 --> ", text.toString())
    }
}