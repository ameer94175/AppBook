package com.example.appbook.adpter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appbook.R
import com.example.appbook.`interface`.BookInteractionListener
import com.example.appbook.databinding.ItemBookBinding
import com.example.appbook.response.Results

class AdapterListBooks(val list:List<Results>, val listener:BookInteractionListener):RecyclerView.Adapter<AdapterListBooks.HolderListBooks>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderListBooks {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return HolderListBooks(view)
    }

    override fun onBindViewHolder(holder: HolderListBooks, position: Int) {
        val list=list[position]
        holder.binding.apply {
            Glide.with(this.root).load(list.formats?.imagejpeg).into(idIVBook)
         idIVBook.setOnClickListener {
             listener.onClickItem(list)
         }
        }
    }

    override fun getItemCount():Int=list.size

     class HolderListBooks(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding= ItemBookBinding.bind(itemView)
    }

}