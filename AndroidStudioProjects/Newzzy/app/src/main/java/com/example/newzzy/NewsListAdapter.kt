package com.example.newzzy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlin.collections.ArrayList

class NewsListAdapter(private val Listener: ItemClicked): RecyclerView.Adapter<NewsViewHolder>() {

    private val items: ArrayList<News> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)  // converts XML files into Views
        val viewHolder = NewsViewHolder(view) //creates instance of the holder.
        view.setOnClickListener{
            Listener.onItemClicked(items[viewHolder.absoluteAdapterPosition])  // activates when item is clicked
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder:NewsViewHolder, position: Int) {

        var currentItem = items[position]
        holder.titleView.text = currentItem.title
        holder.author.text = currentItem.author
        Glide.with(holder.itemView.context).load(currentItem.imageUrl).into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size  //gets the total no of items.
    }
    fun updatedNews(updatedItems : ArrayList<News>){
        items.clear()
        val addAll = items.addAll(updatedItems)
        notifyDataSetChanged()
    }

}

class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val titleView: TextView = itemView.findViewById(R.id.itemNews)
    val image: ImageView = itemView.findViewById(R.id.imageId)
    val author: TextView = itemView.findViewById(R.id.itemAuthor)
}

interface ItemClicked{
    fun onItemClicked(item:News)
}