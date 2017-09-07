package com.scottsu.smovie.module.hot;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.enity.MovieSubject;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.hot
 * description:
 * author: Su
 * date: 2017/9/1 8:02
 */

public class HotItemViewHolder extends SListViewHolder<MovieSubject> {
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mGenresTextView, mDurationTextView, mRatingTextView;
    private RatingBar mRatingBar;

    public HotItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public HotItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mGenresTextView = (TextView) findViewById(R.id.tv_genres);
        mDurationTextView = (TextView) findViewById(R.id.tv_duration);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);
        mRatingBar = (RatingBar) findViewById(R.id.rating_bar_rating);
    }

    @Override
    public void bindData(Context context, MovieSubject entity, int position) {
        double rating = entity.getRating().getAverage();

        ImageLoader.load(context, entity.getImages().getLarge(), mCoverImageView);
        mTitleTextView.setText(entity.getTitle());
        mDurationTextView.setText(entity.getDirectors().isEmpty() ? "-" : entity.getDurations().get(0));
        mRatingTextView.setText(String.valueOf(rating));

        mRatingBar.setProgress((int) entity.getRating().getAverage());

        //Show genres text.
        StringBuilder genresBuilder = new StringBuilder();
        List<String> genres = entity.getGenres();

        for (int i = 0, n = genres.size(); i < n; i++) {
            if (0 == i) {
                genresBuilder.append(genres.get(0));
            } else {
                genresBuilder.append("/");
                genresBuilder.append(genres.get(i));
            }
        }
        mGenresTextView.setText(genresBuilder.toString().isEmpty() ? "-" : genresBuilder.toString());
    }

    public ImageView getCoverImageView() {
        return mCoverImageView;
    }

    public TextView getTitleTextView() {
        return mTitleTextView;
    }

    public TextView getRatingTextView() {
        return mRatingTextView;
    }
}
