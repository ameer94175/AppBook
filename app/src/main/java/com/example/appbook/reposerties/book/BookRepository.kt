package com.example.appbook.reposerties.book

import com.example.appbook.network.Client
import com.example.appbook.network.State
import com.example.appbook.response.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class BookRepository  {
    private val client = Client()
    fun getBookInfo(): Flow<State<Data>> = flow {
     emit(State.Loading)
        emit(client.requestBookData())
    }.flowOn(Dispatchers.IO)
}