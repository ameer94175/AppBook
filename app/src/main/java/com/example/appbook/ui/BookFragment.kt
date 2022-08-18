package com.example.appbook.ui


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.appbook.base.BaseFragment
import com.example.appbook.databinding.BookFragmentBinding
import com.example.appbook.response.Results
import com.example.appbook.util.Constants

class BookFragment() : BaseFragment<BookFragmentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BookFragmentBinding =
        BookFragmentBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book = arguments?.getSerializable(Constants.keyJoinFragment.BOOKKEY) as Results
        viewBook(book)
        binding.bake.setOnClickListener { removeFragment(this) }

    }

    @SuppressLint("SetTextI18n")
    private fun viewBook(book: Results) {
        binding.apply {
            title.text = "Title : ${book.title.toString()}"
            authors.text = "Authors : ${book.authors?.get(0)?.name.toString()}"
            subjects.text = "Subjects : ${book.subjects.toString()}"
            Glide.with(this.root).load(book.formats?.imagejpeg).into(imagebook)
        }
    }

    private fun removeFragment(fragment: Fragment) {
        val transaction = activity?.supportFragmentManager?.beginTransaction()
        transaction?.remove(fragment)
        transaction?.commit()
    }
}