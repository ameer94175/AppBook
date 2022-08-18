package com.example.appbook.model.network

import android.util.Log
import com.example.appbook.response.Data
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class Client {
    private val httpUrlBuilder = HttpUrlBuilder()
    private val httpUrl = httpUrlBuilder.buildHttpUrl()
    private val okHttpClient = OkHttpClient()
    private val gson = Gson()

    fun requestBookData(): State<Data> {
        val request = buildRequest()
        val response = makeRequest(request)
        return checkResponseState(response)
    }

    private fun buildRequest() = Request.Builder().url(httpUrl).build()

    private fun makeRequest(request: Request) = okHttpClient.newCall(request).execute()

    private fun checkResponseState(response: Response) = if (response.isSuccessful) {
        Log.i("HGHFD","$response")

        val book = gson.fromJson(response.body!!.string(), Data::class.java)
        Log.i("HGHFD","$book")
        State.Success(book)
    } else {
        Log.i("HGHFD", response.message)

        State.Fail(response.message)
    }
}