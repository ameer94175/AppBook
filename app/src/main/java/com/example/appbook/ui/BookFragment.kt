package com.example.appbook.ui


import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.appbook.base.BaseFragment
import com.example.appbook.databinding.BookFragmentBinding

class BookFragment() :BaseFragment<BookFragmentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> BookFragmentBinding=BookFragmentBinding::inflate

}