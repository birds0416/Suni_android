package com.example.suni3

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PhoneNumbers {
    @SerializedName("category")
    @Expose
    var category: Int? = null

    @SerializedName("number")
    @Expose
    var number: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("email")
    @Expose
    var email: String? = null
}