package com.example.appbook.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appbook.base.BaseFragment
import com.example.appbook.databinding.BookFragmentBinding

class BookFragment() :BaseFragment<BookFragmentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BookFragmentBinding=BookFragmentBinding::inflate
    val book = arguments?.getSerializable("ameer")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val book = arguments?.getSerializable("ameer")
    }
}