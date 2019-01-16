package com.softgroup.android.androidcomponentsandatx.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("_links")
    var links: Links = Links(),
    @SerializedName("address")
    var address: String = "",
    @SerializedName("dob")
    var dob: String = "",
    @SerializedName("email")
    var email: String = "",
    @SerializedName("gender")
    var gender: String = "",
    @SerializedName("id")
    var id: String = "",
    @SerializedName("name")
    var name: String = "",
    @SerializedName("phone")
    var phone: String = "",
    @SerializedName("status")
    var status: String = "",
    @SerializedName("website")
    var website: String = ""
)