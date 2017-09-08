package com.scottsu.smovie.module.moviedetail.photos;

import android.content.Context;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.photos
 * description:
 * author: Su
 * date: 2017/9/8 11:57
 */

public class MoviePhotoListAdapter extends SListAdapter<MoviePhoto> {
    public MoviePhotoListAdapter(Context context) {
        super(context);
    }

    public MoviePhotoListAdapter(Context context, List<MoviePhoto> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return true;
    }

    @Override
    protected SListViewHolder<MoviePhoto> onCreateVH(ViewGroup parent, int viewType) {
        return new MoviePhotoItemViewHolder(parent, R.layout.item_movie_photos);
    }

    @Override
    protected void onBindVH(SListViewHolder<MoviePhoto> holder, MoviePhoto entity, int position) {
        holder.bindData(getContext(), entity, position);
    }

}
