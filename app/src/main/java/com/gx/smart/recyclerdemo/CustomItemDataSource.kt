package com.gx.smart.recyclerdemo

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
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
        val data = repository.loadPageData(params.key,params.requestedLoadSize)
        data?.let {
            callback.onResult(data, params.key - 1)
        }
    }
}
