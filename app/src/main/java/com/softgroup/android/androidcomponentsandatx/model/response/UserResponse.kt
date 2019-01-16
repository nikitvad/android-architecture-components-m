package com.softgroup.android.androidcomponentsandatx.model.response

import com.google.gson.annotations.SerializedName
import com.softgroup.android.androidcomponentsandatx.model.Meta
import com.softgroup.android.androidcomponentsandatx.model.User

data class UserResponse(
    @SerializedName("_meta")
    var meta: Meta = Meta(),
    @SerializedName("result")
    var result: List<User> = listOf()
)