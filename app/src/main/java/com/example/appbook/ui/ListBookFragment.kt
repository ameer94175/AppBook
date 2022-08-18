package com.example.appbook.ui

import android.os.Bundle
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
import com.example.appbook.model.network.State
import com.example.appbook.reposerties.book.BookRepository
import com.example.appbook.response.Data
import com.example.appbook.response.Results
import com.example.appbook.util.Constants
import com.example.appbook.util.hide
import com.example.appbook.util.show
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class ListBookFragment : BaseFragment<ListBookFragmentBinding>(), BookInteractionListener {
    private val bookFragment = BookFragment()
    private val bookRepository = BookRepository()

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ListBookFragmentBinding =
        ListBookFragmentBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestBookData()
        binding.textTryAgain.setOnClickListener { requestBookData() }
    }

    private fun requestBookData() {
        lifecycleScope.launch(Dispatchers.Main) {
            bookRepository.getBookInfo().catch { showFailState() }.collect { state ->
                showResponseState(state)
            }
        }
    }

    private fun showResponseState(responseState: State<Data>) {
        when (responseState) {
            is State.Fail -> showFailState()
            is State.Loading -> showLoadingState()
            is State.Success -> responseState.data.results?.let { showSuccessState(it) }
        }
    }

    private fun showFailState() {
        binding.apply {
            cropSuccessState.hide()
            cropMain.hide()
            cropFail.show()
        }
    }

    private fun showLoadingState() {
        binding.apply {
            cropLoading.show()
            cropSuccessState.hide()
            cropMain.hide()
            cropFail.hide()
        }

    }

    private fun showSuccessState(responseData: List<Results>) {
        binding.apply {
            cropSuccessState.show()
            cropMain.show()
            cropLoading.hide()
            cropFail.hide()
        }
        bindBooksData(responseData)
    }

    private fun bindBooksData(books: List<Results>) {
        val adpater = AdapterListBooks(books, this)
        binding.recyclerView.adapter = adpater
    }

    override fun onClickItem(book: Results?) {
        val bundle = Bundle()
        bundle.putSerializable(Constants.keyJoinFragment.BOOKKEY, book)
        bookFragment.arguments = bundle
        addFragment(bookFragment)
    }

    private fun addFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.add(R.id.fragment_container, fragment)
        transaction?.commit()
    }

}