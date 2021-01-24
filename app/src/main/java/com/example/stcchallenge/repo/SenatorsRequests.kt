package com.example.stcchallenge.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.stcchallenge.api.ApiSenator
import com.example.stcchallenge.utils.network.BaseRequest
import com.example.stcchallenge.utils.network.Resource
import kotlinx.coroutines.Dispatchers

class SenatorsRequests : BaseRequest<ApiSenator>(ApiSenator::class.java) {

    companion object {
        const val GET_SENATORS_LIST = 1
    }

    internal fun makeRequest(reqId: Int): LiveData<Resource<*>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.loading<Any>(reqId = reqId))
            handleRequest(reqId = reqId)?.let { emit(it) }
            emit(Resource.done<Any>(reqId = reqId))
        }
    }

    private suspend fun handleRequest(reqId: Int): Resource<*>? {
        return try {
            val request = when (reqId) {
                GET_SENATORS_LIST -> allApis.getSenatorsList()
                else -> null
            }
            request?.let { responseHandler.handleSuccess(it, reqId) }
        } catch (e: Exception) {
            responseHandler.handleException(e, reqId)
        }
    }
}