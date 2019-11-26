package com.gx.smart.recyclerdemo

import androidx.paging.DataSource


/**
 *@author xiaosy
 *@create 2019-11-12
 *@Describe
 **/
class CustomItemDataSourceFactory(val repository: DataRepository): DataSource.Factory<Int, Item>() {
    override fun create(): DataSource<Int, Item> {
        return CustomItemKeyDataSource(repository)
    }
}