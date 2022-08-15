package com.example.appbook.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.appbook.adpter.AdapterListBooks
import com.example.appbook.databinding.ActivityMainBinding
import com.example.appbook.network.State
import com.example.appbook.reposerties.book.BookRepository
import com.example.appbook.response.Data
import com.example.appbook.response.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val bookRepository = BookRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
requestBookData()
    }
    private fun requestBookData() {
        lifecycleScope.launch(Dispatchers.Main) {
           bookRepository.getBookInfo().collect{ state ->
                showResponseState(state)
            }
        }
    }
    private fun showResponseState(responseState: State<Data>)= when(responseState) {
        is State.Fail -> showFailState()
        is State.Loading -> showLoadingState()
        is State.Success -> responseState.data.results?.let { showSuccessState(it) }
    }
    private fun showFailState() {
        Log.i("AAAA","AMEER")
    }
    private fun showLoadingState() {
        Log.i("AAAA","AMEER")
    }
    private fun showSuccessState(responseData: List<Results>) {
        bindBooksData(responseData)
    }
    private fun  bindBooksData(books: List<Results>) {
        val adpater=AdapterListBooks(books)
        binding.recyclerView.adapter=adpater
    }

}