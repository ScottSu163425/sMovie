package com.scottsu.smovie.module.common;

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
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 8:48
 **/
public class CommonMovieSubjectItemViewHolder extends SListViewHolder<MovieSubject> {
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mGenresTextView, mYearTextView, mRatingTextView;


    public CommonMovieSubjectItemViewHolder(View itemView) {
        super(itemView);

        init();
    }

    public CommonMovieSubjectItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes) {
        super(parent, layoutRes);

        init();
    }

    private void init() {
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mGenresTextView = (TextView) findViewById(R.id.tv_genres);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);
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
}
