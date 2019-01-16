package com.softgroup.android.androidcomponentsandatx.repository

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

enum class RetrofitService{
    instance;

    val gorestApi:GorestApi
    private val okHttpClient:OkHttpClient
     private val httpLoggingInterceptor:HttpLoggingInterceptor = HttpLoggingInterceptor()
    private val retrofit:Retrofit

    init{

        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(GorestApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        gorestApi = retrofit.create(GorestApi::class.java)
    }

}