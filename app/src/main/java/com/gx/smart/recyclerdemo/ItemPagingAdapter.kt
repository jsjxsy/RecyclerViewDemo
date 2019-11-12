package com.gx.smart.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 * @author xiaosy
 * @create 2019-11-08
 * @Describe
 */
class ItemPagingAdapter : PagedListAdapter<Item, ItemPagingAdapter.ItemViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mContent: TextView = itemView.findViewById(R.id.content)
        var mImage: ImageView = itemView.findViewById(R.id.image)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(
                oldConcert: Item,
                newConcert: Item
            ): Boolean =
                oldConcert.content == newConcert.content

            override fun areContentsTheSame(
                oldConcert: Item,
                newConcert: Item
            ): Boolean =
                oldConcert == newConcert
        }
    }

}