package com.scottsu.smovie.module.moviedetail.photos;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.photos
 * description:
 * author: Su
 * date: 2017/9/8 11:56
 */

public class MoviePhotoGalleryItemViewHolder extends SListViewHolder<MoviePhoto> {
    private ImageView mImageView;

    public MoviePhotoGalleryItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public MoviePhotoGalleryItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mImageView = (ImageView) findViewById(R.id.iv_cover);
    }

    @Override
    public void bindData(Context context, MoviePhoto entity, int position) {
        ImageLoader.load(context, entity.getCover(), mImageView,
                R.color.transparent, R.color.transparent, false, false, null);
    }


}
