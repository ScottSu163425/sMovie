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

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/6 22:45
 */

public class FavoriteMovieListViewHolder extends SListViewHolder<MovieSubject> {
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mGenresTextView, mYearTextView, mRatingTextView;
    private View mMoreView;


    public FavoriteMovieListViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public FavoriteMovieListViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mGenresTextView = (TextView) findViewById(R.id.tv_genres);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);
        mMoreView = findViewById(R.id.fl_more);
    }


    @Override
    public void bindData(Context context, MovieSubject entity, int position) {
        double rating = entity.getRating().getAverage();

        ImageLoader.load(context, entity.getImages().getLarge(), mCoverImageView);
        mTitleTextView.setText(entity.getTitle());
        mYearTextView.setText(entity.getYear());
        mRatingTextView.setText(String.valueOf(rating));

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

    public View getMoreView() {
        return mMoreView;
    }
}
