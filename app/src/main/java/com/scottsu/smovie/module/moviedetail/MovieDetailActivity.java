package com.scottsu.smovie.module.moviedetail;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.utils.CircularRevealUtil;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail
 * description:
 * author: Su
 * date: 2017/9/1 21:26
 */

public class MovieDetailActivity extends BaseActivity<MovieDetailContract.View, MovieDetailContract.Presenter>
        implements MovieDetailContract.View {

    public static final String KEY_EXTRA_MOVIE_SUBJECT = "KEY_EXTRA_MOVIE_SUBJECT";

    private MovieSubject mMovieSubject;
    private MovieDetailResponseEntity mMovieDetailResponseEntity;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private View mHeaderBackground;
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mYearTextView;
    private FloatingActionButton mFavoriteFAB;


    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_movie_detail;
    }

    @Override
    protected MovieDetailContract.Presenter providePresenter() {
        return new MovieDetailPresenter();
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mMovieSubject = (MovieSubject) getIntent().getSerializableExtra(KEY_EXTRA_MOVIE_SUBJECT);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mHeaderBackground = findViewById(R.id.bg_header);
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mFavoriteFAB = (FloatingActionButton) findViewById(R.id.fab_favorite);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mMovieSubject.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        ImageLoader.load(this, mMovieSubject.getImages().getLarge(), mCoverImageView, new ImageLoader.Callback() {
            @Override
            public void onResourceReady(Drawable resource) {
                Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();
                Palette palette = Palette.from(bitmap).generate();
                Palette.Swatch swatch = palette.getMutedSwatch();

                mHeaderBackground.setBackgroundColor(swatch.getRgb());
                mTitleTextView.setTextColor(swatch.getTitleTextColor());
                mYearTextView.setTextColor(swatch.getBodyTextColor());

                mHeaderBackground.post(new Runnable() {
                    @Override
                    public void run() {
                        CircularRevealUtil.revealIn(mHeaderBackground, CircularRevealUtil.CENTER, 1500);
                    }
                });

                mCollapsingToolbarLayout.setContentScrimColor(swatch.getRgb());
                StatusBarUtil.setColor(MovieDetailActivity.this, swatch.getRgb(), 30);
            }
        });

        getPresenter().subscribe(this);
        getPresenter().requestMovieDetail(mMovieSubject.getId());
    }

    @Override
    public void onRequestSuccess(MovieDetailResponseEntity responseEntity) {
        mMovieDetailResponseEntity = responseEntity;
    }

    @Override
    public void onRequestFailed() {
        Toast.makeText(this, "onRequestFailed", Toast.LENGTH_SHORT).show();
    }


}
