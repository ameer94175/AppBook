package com.example.appbook.ui


import android.view.LayoutInflater
import com.example.appbook.base.BaseActivity
import com.example.appbook.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =ActivityMainBinding::inflate
}