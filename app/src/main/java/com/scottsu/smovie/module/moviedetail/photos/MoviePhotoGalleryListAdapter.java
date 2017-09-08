package com.scottsu.smovie.module.moviedetail.photos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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

public class MoviePhotoGalleryListAdapter extends SListAdapter<MoviePhoto> {
    public MoviePhotoGalleryListAdapter(Context context) {
        super(context);
    }

    public MoviePhotoGalleryListAdapter(Context context, List<MoviePhoto> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return false;
    }

    @Override
    protected SListViewHolder<MoviePhoto> onCreateVH(ViewGroup parent, int viewType) {
        return new MoviePhotoGalleryItemViewHolder(parent, R.layout.item_movie_photos_gallery);
    }

    @Override
    protected void onBindVH(SListViewHolder<MoviePhoto> holder, final MoviePhoto entity, final int position) {
        holder.bindData(getContext(), entity, position);
    }

}
