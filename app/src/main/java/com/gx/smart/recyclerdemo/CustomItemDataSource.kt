package com.gx.smart.recyclerdemo

import androidx.paging.PageKeyedDataSource

/**
 * @author xiaosy
 * @create 2019-11-08
 * @Describe
 */
class CustomItemDataSource : PageKeyedDataSource<*, *>() {
    override fun loadInitial(
        params: PageKeyedDataSource.LoadInitialParams<*>,
        callback: PageKeyedDataSource.LoadInitialCallback<*, *>
    ) {
    }

    override fun loadBefore(
        params: PageKeyedDataSource.LoadParams<*>,
        callback: PageKeyedDataSource.LoadCallback<*, *>
    ) {

    }

    override fun loadAfter(
        params: PageKeyedDataSource.LoadParams<*>,
        callback: PageKeyedDataSource.LoadCallback<*, *>
    ) {

    }
}
