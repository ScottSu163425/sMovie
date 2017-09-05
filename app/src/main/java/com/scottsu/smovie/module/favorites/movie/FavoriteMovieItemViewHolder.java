package com.scottsu.smovie.module.favorites.movie;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.enity.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/5 20:57
 */

public class FavoriteMovieItemViewHolder extends SListViewHolder<MovieSubject> {
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mYearTextView, mRatingTextView;

    public FavoriteMovieItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public FavoriteMovieItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);
    }

    @Override
    public void bindData(Context context, MovieSubject entity, int position) {
        double rating = entity.getRating().getAverage();

        ImageLoader.load(context, entity.getImages().getLarge(), mCoverImageView);
        mTitleTextView.setText(entity.getTitle());
        mYearTextView.setText(entity.getYear());
        mRatingTextView.setText(rating > 0 ? String.valueOf(rating) : context.getString(R.string.no_rating));
    }

    public ImageView getCoverImageView() {
        return mCoverImageView;
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }

    public TextView getYearTextView() {
        return mYearTextView;
    }

    public TextView getRatingTextView() {
        return mRatingTextView;
    }
}
