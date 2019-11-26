package com.gx.smart.recyclerdemo

import android.util.Log
import androidx.paging.ItemKeyedDataSource

/**
 * @author xiaosy
 * @create 2019-11-25
 * @Describe
 */
class CustomItemKeyDataSource(val repository: DataRepository) : ItemKeyedDataSource<Int, Item>() {
    override fun loadInitial(
        params: ItemKeyedDataSource.LoadInitialParams<Int>,
        callback: ItemKeyedDataSource.LoadInitialCallback<Item>
    ) {
        val data = repository.loadData(params.requestedLoadSize)
        callback.onResult(data, 0, params.requestedLoadSize)
        Log.e(
            TAG,
            "loadInitial params placeholdersEnabled:${params.placeholdersEnabled} requestedLoadSize:${params.requestedLoadSize}"
        )
    }

    override fun loadAfter(
        params: ItemKeyedDataSource.LoadParams<Int>,
        callback: ItemKeyedDataSource.LoadCallback<Item>
    ) {
        callback.onResult(repository.loadData(params.key))
        Log.e(
            TAG,
            "loadAfter params key:${params.key} requestedLoadSize:${params.requestedLoadSize}"
        )
    }

    override fun loadBefore(
        params: ItemKeyedDataSource.LoadParams<Int>,
        callback: ItemKeyedDataSource.LoadCallback<Item>
    ) {
        callback.onResult(repository.loadData(params.key))
        Log.e(
            TAG,
            "loadBefore params key:${params.key} requestedLoadSize:${params.requestedLoadSize}"
        )
    }

    companion object {
        val TAG = CustomItemDataSource::class.java.toString()
    }

    override fun getKey(item: Item): Int {
        return item.index
    }
}
