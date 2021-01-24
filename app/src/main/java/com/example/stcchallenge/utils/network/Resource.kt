package com.example.stcchallenge.utils.network

data class Resource<out T>(
    val status: Status, val data: T? = null, val message: String? = null, val reqId: Int
) {
    companion object {
        fun <T> success(data: T?, reqId: Int): Resource<T> {
            return Resource(status = Status.SUCCESS, data = data, reqId = reqId)
        }

        fun <T> error(msg: String, data: T? = null, reqId: Int): Resource<T> {
            return Resource(Status.ERROR, data, msg, reqId)
        }

        fun <T> loading(data: T? = null, reqId: Int): Resource<T> {
            return Resource(status = Status.LOADING, data = data, reqId = reqId)
        }

        fun <T> done(data: T? = null, reqId: Int): Resource<T> {
            return Resource(status = Status.DONE, data = data, reqId = reqId)
        }
    }
}