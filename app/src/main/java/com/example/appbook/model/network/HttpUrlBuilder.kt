package com.example.appbook.model.network

import com.example.appbook.util.Constants
import okhttp3.HttpUrl

class HttpUrlBuilder {
    fun buildHttpUrl() = with(Constants.HttpUrl) {
        HttpUrl.Builder()
            .scheme(SCHEME)
            .host(HOST)
            .addPathSegments(PATH_SEGMENTS)
            .build()
    }
}
