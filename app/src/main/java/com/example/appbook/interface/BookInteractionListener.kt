package com.example.appbook.`interface`
import androidx.constraintlayout.widget.R
import com.example.appbook.response.Results

interface BookInteractionListener {
    fun onClickItem(book:Results?)
}