package com.gx.smart.recyclerdemo;

import androidx.recyclerview.widget.DiffUtil;

import java.util.List;

/**
 * @author xiaosy
 * @create 2019-11-12
 * @Describe
 **/
public class DiffCallBack extends DiffUtil.Callback {
    private List<Item> mOldDatas, mNewDatas;//看名字

    public DiffCallBack(List<Item> mOldDatas, List<Item> mNewDatas) {
        this.mOldDatas = mOldDatas;
        this.mNewDatas = mNewDatas;
    }

    @Override
    public int getOldListSize() {
        return mOldDatas != null ? mOldDatas.size() : 0;
    }

    @Override
    public int getNewListSize() {
        return mNewDatas != null ? mNewDatas.size() : 0;
    }

    /**
     * Called by the DiffUtil to decide whether two object represent the same Item.
     * * 被DiffUtil调用，用来判断 两个对象是否是相同的Item。
     * * For example, if your items have unique ids, this method should check their id equality.
     * * 例如，如果你的Item有唯一的id字段，这个方法就 判断id是否相等。
     * * 本例判断name字段是否一致
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldDatas.get(oldItemPosition).getContent().equals(mNewDatas.get(newItemPosition).getContent());
    }

    /**
     * * Called by the DiffUtil when it wants to check whether two items have the same data.
     * * 被DiffUtil调用，用来检查 两个item是否含有相同的数据
     * * DiffUtil uses this information to detect if the contents of an item has changed.
     * * DiffUtil用返回的信息（true false）来检测当前item的内容是否发生了变化
     * * DiffUtil uses this method to check equality instead of {@link Object#equals(Object)}
     * * DiffUtil 用这个方法替代equals方法去检查是否相等。
     * * so that you can change its behavior depending on your UI.
     * * 所以你可以根据你的UI去改变它的返回值
     * * For example, if you are using DiffUtil with a
     * * you should
     * * return whether the items' visual representations are the same.
     * * 例如，如果你用RecyclerView.Adapter 配合DiffUtil使用，你需要返回Item的视觉表现是否相同。
     * * This method is called only if {@link #areItemsTheSame(int, int)} returns
     * * {@code true} for these items.
     * * 这个方法仅仅在areItemsTheSame()返回true时，才调用。
     *
     * @param oldItemPosition
     * @param newItemPosition
     * @return
     */
    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        Item beanOld = mOldDatas.get(oldItemPosition);
        Item beanNew = mNewDatas.get(newItemPosition);
        if (beanOld.getImageUrl() != beanNew.getImageUrl()) {
            return false;//如果有内容不同，就返回false
        }
        return true; //默认两个data内容是相同的
    }
}
