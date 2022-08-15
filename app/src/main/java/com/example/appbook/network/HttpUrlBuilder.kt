package com.example.appbook.network

import com.example.appbook.util.Constants
import okhttp3.HttpUrl

class HttpUrlBuilder {
    fun buildHttpUrl() = with(Constants.HttpUrl) {
        val keys = Constants.HttpUrl.keys
        val values = Constants.HttpUrl.values

        HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(PATH_SEGMENTS)
            .build()
    }
}
