package com.scottsu.smovie.module.favorites.celebrity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.module.moviedetail.celebrity.Celebrity;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.celebrity
 * description:
 * author: Su
 * date: 2017/9/7 9:49
 */

public class FavoriteCelebrityListAdapter extends SListAdapter<Celebrity> {
    private Callback mCallback;
    public FavoriteCelebrityListAdapter(Context context) {
        super(context);
    }

    public FavoriteCelebrityListAdapter(Context context, List<Celebrity> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return true;
    }

    @Override
    protected SListViewHolder<Celebrity> onCreateVH(ViewGroup parent, int viewType) {
        return new FavoriteCelebrityListViewHolder(parent, R.layout.item_favorite_celebrity);
    }

    @Override
    protected void onBindVH(SListViewHolder<Celebrity> holder, final Celebrity entity, final int position) {
        FavoriteCelebrityListViewHolder viewHolder = (FavoriteCelebrityListViewHolder) holder;

        viewHolder.bindData(getContext(), entity, position);

        viewHolder.getMoreView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCallback().onMoreClick(view, entity, position);
            }
        });
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    private Callback getCallback() {
        if (mCallback == null) {
            mCallback = new Callback() {
                @Override
                public void onMoreClick(View view, Celebrity entity, int position) {

                }
            };
        }
        return mCallback;
    }

    public interface Callback {
        void onMoreClick(View view, Celebrity entity, int position);
    }


}
