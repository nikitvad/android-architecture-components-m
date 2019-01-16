package com.softgroup.android.androidcomponentsandatx.model

import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("code")
    var code: Int = 0,
    @SerializedName("currentPage")
    var currentPage: Int = 0,
    @SerializedName("message")
    var message: String = "",
    @SerializedName("pageCount")
    var pageCount: Int = 0,
    @SerializedName("perPage")
    var perPage: Int = 0,
    @SerializedName("rateLimit")
    var rateLimit: RateLimit = RateLimit(),
    @SerializedName("success")
    var success: Boolean = false,
    @SerializedName("totalCount")
    var totalCount: Int = 0
)