package com.example.stcchallenge.utils.network

import com.example.stcchallenge.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ServiceGenerator {
    private val httpClient = OkHttpClient.Builder()
    private lateinit var builder: Retrofit.Builder

    fun getRetrofit(timeOut: Long = 30): Retrofit {
        httpClient.readTimeout(timeOut, TimeUnit.SECONDS)
        httpClient.connectTimeout(timeOut, TimeUnit.SECONDS)
        val gsonObject = GsonBuilder().setLenient().create()
        httpClient.addInterceptor { chain ->
            val original = chain.request()
            val request = original.newBuilder()
                .header("Content-Type", "application/json")
                .method(original.method, original.body)
                .build()
            chain.proceed(request.newBuilder().build())
        }
        builder = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gsonObject))
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        httpClient.interceptors().add(interceptor)
        return builder.client(httpClient.build()).build()
    }
}



