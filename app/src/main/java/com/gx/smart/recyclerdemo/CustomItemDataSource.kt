package com.gx.smart.recyclerdemo

import android.util.Log
import androidx.paging.PageKeyedDataSource

/**
 * @author xiaosy
 * @create 2019-11-08
 * @Describe
 */
class CustomItemDataSource(val repository: DataRepository) : PageKeyedDataSource<Int, Item>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Item>
    ) {
        val data = repository.loadData(params.requestedLoadSize)
        callback.onResult(data, null, 2)
        Log.e(TAG, "loadInitial params placeholdersEnabled:${params.placeholdersEnabled} requestedLoadSize:${params.requestedLoadSize}")
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key + 1)
        }
        Log.e(TAG, "loadAfter params key:${params.key} requestedLoadSize:${params.requestedLoadSize}")
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key - 1)
        }
        Log.e(TAG, "loadBefore params key:${params.key} requestedLoadSize:${params.requestedLoadSize}")
    }

    companion object {
        val TAG = CustomItemDataSource::class.java.toString()
    }
}
