package com.example.stcchallenge.models

import com.google.gson.annotations.SerializedName

open class BaseModel(
    var success: Boolean? = null,
    val meta: Meta? = null
) {
    data class Error(val code: String? = null, val message: String? = null)

    data class Meta(
        val limit: Long? = null,
        val offset: Long? = null,
        @SerializedName("total_count")
        val totalCount: Long? = null
    )
}