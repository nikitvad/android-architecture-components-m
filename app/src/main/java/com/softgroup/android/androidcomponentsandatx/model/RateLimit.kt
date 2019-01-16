package com.softgroup.android.androidcomponentsandatx.model

import com.google.gson.annotations.SerializedName

data class RateLimit(
    @SerializedName("limit")
    var limit: Int = 0,
    @SerializedName("remaining")
    var remaining: Int = 0,
    @SerializedName("reset")
    var reset: Int = 0
)