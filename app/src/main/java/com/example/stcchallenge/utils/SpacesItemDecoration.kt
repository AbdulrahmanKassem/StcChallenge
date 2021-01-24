package com.example.stcchallenge.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class SpacesItemDecoration(private val mSpace: IntArray) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.left = mSpace[LEFT]
        outRect.top = mSpace[TOP]
        outRect.right = mSpace[RIGHT]
        outRect.bottom = mSpace[BOTTOM]
    }

    companion object {
        private const val LEFT = 0
        private const val TOP = 1
        private const val RIGHT = 2
        private const val BOTTOM = 3
    }
}