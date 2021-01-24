package com.example.stcchallenge.models

open class BaseModel(
    var success: Boolean? = null,
    val message: String? = null,
    val error: Error? = null
) {
    data class Error(val code: String? = null, val message: String? = null)
}