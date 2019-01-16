package com.softgroup.android.androidcomponentsandatx.model

import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("avatar")
    var avatar: Avatar = Avatar(),
    @SerializedName("self")
    var self: Self = Self()
)