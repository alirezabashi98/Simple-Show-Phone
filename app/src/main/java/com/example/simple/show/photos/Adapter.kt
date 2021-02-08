package com.example.simple.show.photos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class Adapter @Inject constructor(var images: List<Int>, var requestManager: RequestManager) :
    RecyclerView.Adapter<Adapter.ViewHolderAdapter>() {

    inner class ViewHolderAdapter(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.image_list)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAdapter =
        ViewHolderAdapter(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolderAdapter, position: Int) {
        requestManager.load(images[position]).into(holder.image)
    }

    override fun getItemCount(): Int = images.size

}