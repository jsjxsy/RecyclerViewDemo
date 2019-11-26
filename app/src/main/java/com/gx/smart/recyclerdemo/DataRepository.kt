package com.gx.smart.recyclerdemo

import android.content.Context
import android.util.Log

/**
 *@author xiaosy
 *@create 2019-11-12
 *@Describe
 **/
class DataRepository {
    private val data = ArrayList<Item>()
    private var ctx: Context

    constructor(ctx: Context) {
        this.ctx = ctx
        for (index in 1..100) {
            val content = "this is item $index "
            val images = ctx.resources.getStringArray(R.array.iamges)
            val i = index % 10
            Log.e("images", images[i])
            val item = Item(index, images[i], content)
            data.add(item)
        }
    }


    fun loadData(size: Int): List<Item> {
        Log.e(TAG, "loadData")
        return data.subList(0, size)
    }

    fun loadData(index: Int, size: Int): List<Item>? {
        if (index >= data.size - 1 || index < 1) {
            return null
        }

        if (index + size > data.size) {
            return data.subList(index + 1, data.size)
        }
        return data.subList(index + 1, index + size)
    }

    fun loadPageData(page: Int, size: Int): List<Item>? {
        Log.e(TAG, "loadPageData")
        val totalPage = if (data.size % size == 0) {
            data.size / size
        } else {
            data.size / size + 1
        }

        if (page > totalPage || page < 1) {
            return null
        }

        if (page == totalPage) {
            return data.subList((page - 1) * size, data.size)
        }
        return data.subList((page - 1) * size, page * size)
    }

    companion object{
        val TAG = DataRepository::class.java.toString()
    }
}