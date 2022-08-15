package com.example.appbook.response

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("count") val count: Int?,
    @SerializedName("next") val next: String?,
    @SerializedName("previous") val previous: String?,
    @SerializedName("results") val results: List<Results>?
)
