package com.example.stcchallenge.utils.network

import com.example.stcchallenge.models.BaseModel
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException


open class ResponseHandler {

    fun <T : Any> handleSuccess(data: T, reqId: Int): Resource<T> {
        return Resource.success(data, reqId)
    }

    fun handleException(e: Exception, reqId: Int): Resource<BaseModel>? {
        return if (e is HttpException) {
            try {
                val jObjError = JSONObject(e.response()?.errorBody()?.string() ?: "")
                val error = Gson().fromJson(jObjError.toString(), BaseModel::class.java)
                Resource.error(getErrorMessage(e.code()), error, reqId)
            } catch (eJson: JSONException) {
                Resource.error(getErrorMessage(e.code()), null, reqId)
            }

        } else {
            when (e) {
                is SocketTimeoutException -> Resource.error("Network access timed out", null, reqId)
                is UnknownHostException -> Resource.error("The network cannot connect", null, reqId)
                is ConnectException -> Resource.error("The network cannot connect", null, reqId)
                is NoRouteToHostException -> Resource.error("Can't access the network", null, reqId)
                is JsonSyntaxException -> Resource.error("Response data format error", null, reqId)
                else -> Resource.error("unknown mistake：" + e.localizedMessage, null, reqId)
            }
        }
    }

    private fun getErrorMessage(code: Int): String {
        return when (code) {
            400 -> "Illegal request"
            403 -> "illegal behavior"
            401 -> "UnAuth"
            404 -> "No resources found"
            405 -> "Illegal request"
            408 -> "Request timed out"
            500 -> "Internal server error"
            502 -> "Server gateway error"
            504 -> "Server gateway timeout"
            else -> "Something went wrong"
        }
    }

}

