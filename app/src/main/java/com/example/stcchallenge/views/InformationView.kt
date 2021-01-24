package com.example.stcchallenge.views

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.stcchallenge.R
import com.example.stcchallenge.utils.compatColor
import kotlinx.android.synthetic.main.view_information.view.*

class InformationView(context: Context, attributeSet: AttributeSet? = null) :
    ConstraintLayout(context, attributeSet) {
    init {
        View.inflate(context, R.layout.view_information, this)
        val typedArray = context.theme.obtainStyledAttributes(
            attributeSet, R.styleable.InformationView, 0, 0
        )

        tv_information.textSize=15f
        tv_information.setTextColor(
            (typedArray.getColor(
                R.styleable.InformationView_text_color, compatColor(R.color.light_text_color)
            ))
        )

        tv_title.setTextColor(
            (typedArray.getColor(
                R.styleable.InformationView_title_color, compatColor(R.color.text_color)
            ))
        )

        tv_title.text = (typedArray.getString(R.styleable.InformationView_title))
    }

    internal fun setInformation(information: String) {
        tv_information.text = information
    }
}