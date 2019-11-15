package com.gx.smart.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

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
        val item = getItem(position)
        holder.mContent.text = item?.content

        if (position % 2 == 0) {
            Glide.with(holder.mImage.context).load(item?.imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mImage) //holder.mImage
        } else if (position % 3 == 0) {
            Glide.with(holder.mImage.context).load(item?.imageUrl)
                .apply(RequestOptions.bitmapTransform(GlideBlurformation(holder.mImage.context)))
                .into(holder.mImage) //holder.mImage
        } else if (position % 5 == 0) {
            Glide.with(holder.mImage.context).load(item?.imageUrl)
                .transform(CenterCrop(), RoundedCorners(10))
                .into(holder.mImage)
        } else {
            Glide.with(holder.mImage).load(item?.imageUrl).into(holder.mImage) //holder.mImage
        }

        Glide.with(holder.mGif).asGif().load(R.mipmap.sample).into(holder.mGif)
    }

     class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mContent: TextView = itemView.findViewById(R.id.content)
        var mImage: ImageView = itemView.findViewById(R.id.image)
        var mGif: ImageView = itemView.findViewById(R.id.gif)

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
                oldConcert.imageUrl == newConcert.imageUrl
        }
    }

}