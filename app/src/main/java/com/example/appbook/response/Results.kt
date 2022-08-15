package com.example.appbook.response

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("id") val id: Int?,
    @SerializedName("title") val title: String?,
    @SerializedName("authors") val authors: List<Authors>?,
    @SerializedName("translators") val translators: List<Translators>?,
    @SerializedName("subjects") val subjects: List<String>?,
    @SerializedName("bookshelves") val bookshelves: List<String>?,
    @SerializedName("languages") val languages: List<String>?,
    @SerializedName("copyright") val copyright: Boolean?,
    @SerializedName("media_type") val media_type: String?,
    @SerializedName("formats") val formats: Formats?,
    @SerializedName("download_count") val download_count: Int?
    )
