package com.scottsu.smovie.module.moviedetail;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.utils.CircularRevealUtil;
import com.scottsu.utils.ViewUtil;

import java.util.List;

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

    private LinearLayout mScrollContentParent;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private View mHeaderBackground;
    private ImageView mCoverImageView;
    private TextView mAKATitleTextView, mDirectorTitleTextView, mYearTitleTextView, mRegionTitleTextView,
            mGenreTitleTextView, mCastTitleTextView;
    private TextView mAKATextView, mDirectorTextView, mYearTextView, mRegionTextView, mGenreTextView,
            mCastTextView;
    private CardView mSummaryCard;
    private TextView mSummaryTextView;
    private View mSummaryArrow;

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

        mScrollContentParent = (LinearLayout) findViewById(R.id.ll_content);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mHeaderBackground = findViewById(R.id.bg_header);
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mFavoriteFAB = (FloatingActionButton) findViewById(R.id.fab_favorite);
        mSummaryCard = (CardView) findViewById(R.id.card_summary);
        mSummaryTextView = (TextView) findViewById(R.id.tv_summary);
        mSummaryArrow = findViewById(R.id.iv_arrow_summary);

        mAKATextView = (TextView) findViewById(R.id.tv_aka);
        mDirectorTextView = (TextView) findViewById(R.id.tv_director);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mRegionTextView = (TextView) findViewById(R.id.tv_region);
        mGenreTextView = (TextView) findViewById(R.id.tv_genre);
        mCastTextView = (TextView) findViewById(R.id.tv_cast);

        mAKATitleTextView = (TextView) findViewById(R.id.anchor_aka);
        mDirectorTitleTextView = (TextView) findViewById(R.id.anchor_director);
        mYearTitleTextView = (TextView) findViewById(R.id.anchor_year);
        mRegionTitleTextView = (TextView) findViewById(R.id.anchor_region);
        mGenreTitleTextView = (TextView) findViewById(R.id.anchor_genre);
        mCastTitleTextView = (TextView) findViewById(R.id.anchor_cast);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(mMovieSubject.getTitle());
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mSummaryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ViewUtil.isFastClick()) {
                    return;
                }

                mSummaryCard.setSelected(!mSummaryCard.isSelected());

                final int duration = 300;
                final int maxLineCollapsed = 4;
                final TimeInterpolator interpolator = new FastOutSlowInInterpolator();

                AutoTransition transition = new AutoTransition();
                transition.setDuration(duration)
                        .setInterpolator(interpolator);

                TransitionManager.beginDelayedTransition(mScrollContentParent, transition);

                if (mSummaryCard.isSelected()) {
                    mSummaryTextView.setMaxLines(Integer.MAX_VALUE);
                } else {
                    mSummaryTextView.setMaxLines(maxLineCollapsed);
                }

                mSummaryArrow.animate()
                        .setDuration(duration)
                        .rotation(mSummaryArrow.getRotation() + (mSummaryCard.isSelected() ? 180 : -180))
                        .setInterpolator(interpolator)
                        .start();
            }
        });

        loadCover();

        getPresenter().subscribe(this);
        getPresenter().requestMovieDetail(mMovieSubject.getId());
    }

    private void loadCover() {
        ImageLoader.load(this, mMovieSubject.getImages().getLarge(), mCoverImageView, new ImageLoader.Callback() {
            @Override
            public void onResourceReady(Drawable resource) {
                Bitmap bitmap = ((BitmapDrawable) resource).getBitmap();

                Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
                    @Override
                    public void onGenerated(Palette palette) {
                        Palette.Swatch primarySwatch = palette.getDominantSwatch();
                        Palette.Swatch secondarySwatch = palette.getMutedSwatch();

                        mHeaderBackground.setBackgroundColor(primarySwatch.getRgb());

                        setUpTextColor(primarySwatch.getTitleTextColor(), primarySwatch.getBodyTextColor());

                        final int duration = 1200;
                        mHeaderBackground.post(new Runnable() {
                            @Override
                            public void run() {
                                CircularRevealUtil.revealIn(mHeaderBackground, CircularRevealUtil.CENTER, duration);
                            }
                        });

                        mFavoriteFAB.post(new Runnable() {
                            @Override
                            public void run() {
                                mFavoriteFAB.setScaleX(0);
                                mFavoriteFAB.setScaleY(0);

                                mFavoriteFAB.animate()
                                        .setDuration(duration/2)
                                        .setInterpolator(new FastOutSlowInInterpolator())
                                        .rotation(360)
                                        .scaleX(1)
                                        .scaleY(1)
                                        .start();
                            }
                        });

                        mFavoriteFAB.setBackgroundTintList(ColorStateList.valueOf(secondarySwatch.getRgb()));

                        mCollapsingToolbarLayout.setContentScrimColor(primarySwatch.getRgb());
                        StatusBarUtil.setColor(MovieDetailActivity.this, primarySwatch.getRgb(), 30);
                    }
                });
            }
        });
    }

    private void setUpTextColor(int titleTextColor, int bodyTextColor) {
        mAKATitleTextView.setTextColor(titleTextColor);
        mDirectorTitleTextView.setTextColor(titleTextColor);
        mYearTitleTextView.setTextColor(titleTextColor);
        mRegionTitleTextView.setTextColor(titleTextColor);
        mGenreTitleTextView.setTextColor(titleTextColor);
        mCastTitleTextView.setTextColor(titleTextColor);

        mAKATextView.setTextColor(bodyTextColor);
        mDirectorTextView.setTextColor(bodyTextColor);
        mYearTextView.setTextColor(bodyTextColor);
        mRegionTextView.setTextColor(bodyTextColor);
        mGenreTextView.setTextColor(bodyTextColor);
        mCastTextView.setTextColor(bodyTextColor);
    }

    @Override
    public void onRequestSuccess(MovieDetailResponseEntity responseEntity) {
        mMovieDetailResponseEntity = responseEntity;

        if (mMovieDetailResponseEntity != null) {
            mAKATextView.setText(responseEntity.getAka().isEmpty() ? "-" : responseEntity.getAka().get(0));
            mDirectorTextView.setText(responseEntity.getDirectors().isEmpty() ? "-"
                    : responseEntity.getDirectors().get(0).getName());
            mYearTextView.setText(responseEntity.getYear());
            mRegionTextView.setText(responseEntity.getCountries().isEmpty() ? "-" : responseEntity.getCountries().get(0));
            mSummaryTextView.setText("    " + responseEntity.getSummary());

            //Build genres.
            StringBuilder genresBuilder = new StringBuilder();
            List<String> genres = responseEntity.getGenres();

            for (int i = 0, n = genres.size(); i < n; i++) {
                if (0 == i) {
                    genresBuilder.append(genres.get(0));
                } else {
                    genresBuilder.append("/");
                    genresBuilder.append(genres.get(i));
                }
            }

            mGenreTextView.setText(genresBuilder.toString().isEmpty() ? "-" : genresBuilder.toString());

            //Build casts.
            StringBuilder castBuilder = new StringBuilder();
            List<MovieDetailResponseEntity.CastsBean> casts = responseEntity.getCasts();

            for (int i = 0, n = casts.size(); i < n; i++) {
                if (0 == i) {
                    castBuilder.append(casts.get(0).getName());
                } else {
                    castBuilder.append("/");
                    castBuilder.append(casts.get(i).getName());
                }
            }

            mCastTextView.setText(castBuilder.toString().isEmpty() ? "-" : castBuilder.toString());
        }

    }

    @Override
    public void onRequestFailed(String message) {
        showSnackbar("出错了..(" + message + ")");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mFavoriteFAB.setVisibility(View.GONE);
    }


}
