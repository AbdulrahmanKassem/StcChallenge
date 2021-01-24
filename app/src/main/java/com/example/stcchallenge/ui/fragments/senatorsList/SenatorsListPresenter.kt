package com.example.stcchallenge.ui.fragments.senatorsList

import androidx.lifecycle.LifecycleOwner
import com.example.stcchallenge.models.BaseModel
import com.example.stcchallenge.models.Senator
import com.example.stcchallenge.repo.SenatorsRequests
import com.example.stcchallenge.utils.cast
import com.example.stcchallenge.utils.network.Status

open class SenatorsListPresenter(private var view: View? = null) {

    open fun getSenatorsList(reqId: Int, lifecycleOwner: LifecycleOwner) {
        SenatorsRequests().makeRequest(reqId = reqId)
            .observe(lifecycleOwner, { theResponse ->
                when (theResponse.status) {
                    Status.SUCCESS -> {
                        view?.updateList()
                    }
                    Status.ERROR -> view?.showError(theResponse.data.cast<BaseModel.Error>()?.message)
                    Status.LOADING -> view?.showProgressBar()
                    Status.DONE -> view?.hideProgressBar()
                }
            })
    }

    interface View {
        fun updateList()
        fun showError(errorMessage: String?)
        fun showProgressBar()
        fun hideProgressBar()
    }
}