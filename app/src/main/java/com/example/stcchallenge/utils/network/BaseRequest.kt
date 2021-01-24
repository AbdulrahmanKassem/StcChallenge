package com.example.stcchallenge.utils.network

import android.content.Context
import androidx.lifecycle.MediatorLiveData

open class BaseRequest<T>(serverClass:Class<T>) {
    internal val responseHandler = ResponseHandler()
    internal val allApis = ServiceGenerator().getRetrofit().create(serverClass)
    internal val result = MediatorLiveData<Resource<*>>()

}