package com.example.appbook.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.appbook.base.BaseFragment
import com.example.appbook.databinding.ListBookFragmentBinding

class ListBookFragment:BaseFragment<ListBookFragmentBinding>() {
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> ListBookFragmentBinding=ListBookFragmentBinding::inflate

}