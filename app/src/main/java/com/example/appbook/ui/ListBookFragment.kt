package com.example.appbook.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.appbook.R
import com.example.appbook.`interface`.BookInteractionListener
import com.example.appbook.adpter.AdapterListBooks
import com.example.appbook.base.BaseFragment
import com.example.appbook.databinding.ListBookFragmentBinding
import com.example.appbook.network.State
import com.example.appbook.reposerties.book.BookRepository
import com.example.appbook.response.Data
import com.example.appbook.response.Results
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListBookFragment:BaseFragment<ListBookFragmentBinding>(),BookInteractionListener {
    val BookFragment= BookFragment()
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ListBookFragmentBinding=ListBookFragmentBinding::inflate
    val bookRepository = BookRepository()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
     requestBookData()
    }
        private fun requestBookData() {
            lifecycleScope.launch(Dispatchers.Main) {
                bookRepository.getBookInfo().collect { state ->
                    showResponseState(state)
                }
            }
        }

        private fun showResponseState(responseState: State<Data>) = when (responseState) {
            is State.Fail -> showFailState()
            is State.Loading -> showLoadingState()
            is State.Success -> responseState.data.results?.let { showSuccessState(it) }
        }

        private fun showFailState() {
            Log.i("AAAA", "AMEER")
        }

        private fun showLoadingState() {
            Log.i("AAAA", "AMEER")
        }

        private fun showSuccessState(responseData: List<Results>) {
            bindBooksData(responseData)
        }

        private fun bindBooksData(books: List<Results>){
            val adpater = AdapterListBooks(books,this)
            binding.recyclerView.adapter = adpater
        }

    override fun onClickItem(book: String?) {
        val bundle = Bundle()
        bundle.putSerializable("ameer",book)
        BookFragment.arguments = bundle
        openFragment(BookFragment)
    }
fun openFragment(fragment:Fragment){
            val transaction= activity?.supportFragmentManager?.beginTransaction()
    transaction?.add(R.id.fragment_container,fragment)
    transaction?.commit()
}

}