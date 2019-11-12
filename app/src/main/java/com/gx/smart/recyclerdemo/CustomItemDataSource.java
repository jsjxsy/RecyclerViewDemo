package com.gx.smart.recyclerdemo;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

/**
 * @author xiaosy
 * @create 2019-11-08
 * @Describe
 **/
public class CustomItemDataSource extends PageKeyedDataSource {
    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback callback) {
    }

    @Override
    public void loadBefore(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams params, @NonNull LoadCallback callback) {

    }
}
