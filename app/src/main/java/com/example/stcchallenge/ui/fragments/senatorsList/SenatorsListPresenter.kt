package com.example.stcchallenge.ui.fragments.senatorsList

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.stcchallenge.models.Senator
import com.example.stcchallenge.utils.FetchJsonData

open class SenatorsListPresenter(private var view: View? = null) {

    open fun getSenatorsList(context: Context, lifecycleOwner: LifecycleOwner) {
        view?.updateList(FetchJsonData.loadStoreData(context))
    }

    interface View {
        fun updateList(newList: ArrayList<Senator>)

    }
}