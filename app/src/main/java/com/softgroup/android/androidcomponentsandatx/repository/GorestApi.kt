package com.softgroup.android.androidcomponentsandatx.repository

import com.softgroup.android.androidcomponentsandatx.model.response.UserResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface GorestApi {
    companion object {
        const val TOKEN = "tjMiSW63IYLoblPZdsLarsj9V5VSbBko3f9m"
        const val BASE_URL = "https://gorest.co.in"
    }


    @Headers("Authorization:Bearer $TOKEN")
    @GET("/public-api/users/")
    fun getUsers():Observable<Response<UserResponse>>

}