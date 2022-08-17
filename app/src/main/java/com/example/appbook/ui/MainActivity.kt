package com.example.appbook.ui


import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.appbook.R
import com.example.appbook.`interface`.BookInteractionListener
import com.example.appbook.base.BaseActivity
import com.example.appbook.databinding.ActivityMainBinding
import com.example.appbook.response.Results

class MainActivity : BaseActivity<ActivityMainBinding>() {
    val bookListFragment=ListBookFragment()
    val bookFragment=BookFragment()
    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding =ActivityMainBinding::inflate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showFragmentListBook()
    }
    private fun showFragmentListBook() {
        val transaction=supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container,bookListFragment)
        transaction.commit()
    }



//    override fun onClickItem(book: Results) {
//        val bundle = Bundle()
//        bundle.putSerializable("ameer",book)
//        bookFragment.arguments = bundle
//        (bookFragment)
//    }


}