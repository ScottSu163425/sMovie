package com.scottsu.smovie.common;

import android.support.v7.widget.RecyclerView;


/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 16:25
 **/
public abstract class OnDraggingListener extends RecyclerView.OnScrollListener
{
    public abstract void onDragging();

    public abstract void onReleased();


    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState)
    {
        super.onScrollStateChanged(recyclerView, newState);

        if (RecyclerView.SCROLL_STATE_DRAGGING == newState)
        {
            onDragging();
        } else  /*if (RecyclerView.SCROLL_STATE_SETTLING== newState)*/
        {
            onReleased();
        }
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy)
    {
        super.onScrolled(recyclerView, dx, dy);
    }


}
