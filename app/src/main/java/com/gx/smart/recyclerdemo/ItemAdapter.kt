package com.gx.smart.recyclerdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class ItemAdapter(private val mList: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    //返回item个数
    override fun getItemCount(): Int {
        return mList.size
    }

    //创建ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout,
                parent,
                false
            )
        )
    }

    //填充视图
    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {
        val item = mList[position]
        holder.mContent.text = item.content

        if (position % 2 == 0) {
            Glide.with(holder.mImage.context).load(item.imageUrl)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.mImage) //holder.mImage
        } else if (position % 3 == 0) {
            Glide.with(holder.mImage.context).load(item.imageUrl)
                .apply(RequestOptions.bitmapTransform(GlideBlurformation(holder.mImage.context)))
                .into(holder.mImage) //holder.mImage
        } else if (position % 5 == 0) {
            Glide.with(holder.mImage.context).load(item.imageUrl)
                .transform(CenterCrop(), RoundedCorners(10))
                .into(holder.mImage)
        } else {
            Glide.with(holder.mImage).load(item.imageUrl).into(holder.mImage) //holder.mImage
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mContent: TextView = itemView.findViewById(R.id.content)
        var mImage: ImageView = itemView.findViewById(R.id.image)

    }
}
