package com.example.stcchallenge.utils

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import androidx.activity.OnBackPressedDispatcherOwner
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.stcchallenge.views.InformationView


object ViewBinding {
    @JvmStatic
    @BindingAdapter("loadImage", "errorImage")
    fun bindLoadImage(view: ImageView, url: Drawable?, errorImage: Drawable) {
        Glide.with(view.context.applicationContext)
            .load(url)
            .error(errorImage)
            .centerInside()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .into(view)
    }

    @JvmStatic
    @BindingAdapter("text")
    fun text(view: InformationView, text: String) {
        view.setInformation(text)
    }

    @JvmStatic
    @BindingAdapter("onBackPressed")
    fun bindOnBackPressed(view: View, onBackPress: Boolean) {
        val context = view.context
        if (onBackPress && context is OnBackPressedDispatcherOwner) {
            view.setOnClickListener {
                context.onBackPressedDispatcher.onBackPressed()
            }
        }
    }

}
