package com.example.stcchallenge.api

import com.google.gson.JsonObject
import retrofit2.http.GET

interface ApiSenator {

    @GET("api/orders/occaciontypes")
    suspend fun getSenatorsList(): JsonObject

}