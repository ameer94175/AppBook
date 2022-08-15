package com.example.appbook.response

import com.google.gson.annotations.SerializedName

data class Formats(
    @SerializedName("application/x-mobipocket-ebook") val application: String?,
    @SerializedName("application/epub+zip") val applicationepub: String?,
    @SerializedName("application/rdf+xml") val applicationrdf: String?,
    @SerializedName("text/html; charset=utf-8") val texthtmlcharset: String?,
    @SerializedName("application/zip") val applicationzip: String?,
    @SerializedName("text/plain; charset=utf-8") val textplaincharset: String?,
    @SerializedName("image/jpeg") val imagejpeg: String?,
    @SerializedName("text/html") val texthtml: String?
    )
