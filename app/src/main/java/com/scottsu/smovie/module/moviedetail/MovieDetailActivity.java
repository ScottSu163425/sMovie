package com.scottsu.smovie.module.moviedetail;

import android.animation.TimeInterpolator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionManager;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.enity.MovieDetailResponseEntity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.module.moviedetail.celebrity.Celebrity;
import com.scottsu.smovie.module.moviedetail.celebrity.CelebrityListAdapter;
import com.scottsu.smovie.module.moviedetail.photos.MoviePhoto;
import com.scottsu.smovie.module.moviedetail.photos.MoviePhotoListAdapter;
import com.scottsu.smovie.module.web.CommonWebActivity;
import com.scottsu.utils.ActivityLauncher;
import com.scottsu.utils.ViewUtil;

import java.util.ArrayList;
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

    private AppBarLayout mAppBarLayout;
    private LinearLayout mScrollContentParent;
    private Toolbar mToolbar;
    private ImageView mCoverImageView, mDirectorImageView;
    private TextView mTitleTextView, mYearTextView, mGenresTextView, mSummaryTextView,
            mDurationTextView, mDirectorTextView, mRatingTextView;
    private RatingBar mRatingBar;

    private View mPhotosContentView, mSummaryContentView, mCastsContentView;
    private RecyclerView mPhotosRecyclerView, mCastsRecyclerView;
    private MoviePhotoListAdapter mPhotoListAdapter;
    private CelebrityListAdapter mCastListAdapter;
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
        StatusBarUtil.setTranslucentForImageView(MovieDetailActivity.this, 30, null);

        mMovieSubject = (MovieSubject) getIntent().getSerializableExtra(KEY_EXTRA_MOVIE_SUBJECT);

        mAppBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mScrollContentParent = (LinearLayout) findViewById(R.id.ll_content);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mGenresTextView = (TextView) findViewById(R.id.tv_genres);
        mDurationTextView = (TextView) findViewById(R.id.tv_duration);
        mDirectorTextView = (TextView) findViewById(R.id.tv_director);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);

        mRatingBar = (RatingBar) findViewById(R.id.rating_bar_rating);

        mDirectorImageView = (ImageView) findViewById(R.id.iv_director);
        mFavoriteFAB = (FloatingActionButton) findViewById(R.id.fab_favorite);
        mPhotosContentView = findViewById(R.id.fl_photos);
        mSummaryContentView = findViewById(R.id.fl_summary);
        mSummaryTextView = (TextView) findViewById(R.id.tv_summary);
        mPhotosRecyclerView = (RecyclerView) findViewById(R.id.rv_photos);
        mCastsRecyclerView = (RecyclerView) findViewById(R.id.rv_casts);
        mCastsContentView = findViewById(R.id.fl_casts);

        mTitleTextView.setText(mMovieSubject.getTitle());
        mYearTextView.setText(mMovieSubject.getYear());

        mFavoriteFAB.setOnClickListener(this);

        //Setup toolbar.
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(mMovieSubject.getTitle());
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int totalHeight = mAppBarLayout.getTotalScrollRange();
                float factor = Math.abs((verticalOffset / totalHeight));

                if (factor > 0.8) {
                    mToolbar.setTitleTextColor(Color.WHITE);
                } else {
                    mToolbar.setTitleTextColor(Color.TRANSPARENT);
                }
            }
        });

        mSummaryContentView.setOnClickListener(mSummaryCardClickListener);

        //Setup photos list.
        mPhotosRecyclerView.setLayoutManager(new LinearLayoutManager(MovieDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
        mPhotosRecyclerView.setHasFixedSize(true);
        mPhotosRecyclerView.setNestedScrollingEnabled(false);
        new LinearSnapHelper().attachToRecyclerView(mPhotosRecyclerView);
        mPhotoListAdapter = new MoviePhotoListAdapter(MovieDetailActivity.this);
        mPhotoListAdapter.setItemCallback(new ListItemCallback<MoviePhoto>() {
            @Override
            public void onListItemClick(View itemView, MoviePhoto entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                showMoviePhotos(mPhotoListAdapter.getData(), position);
            }

            @Override
            public void onListItemLongClick(View itemView, MoviePhoto entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {

            }
        });
        mPhotosRecyclerView.setAdapter(mPhotoListAdapter);

        //Setup casts list.
        mCastsRecyclerView.setLayoutManager(new LinearLayoutManager(MovieDetailActivity.this, LinearLayoutManager.VERTICAL, false));
        mCastsRecyclerView.setHasFixedSize(true);
        mCastsRecyclerView.setNestedScrollingEnabled(false);
        mCastListAdapter = new CelebrityListAdapter(MovieDetailActivity.this);
        mCastListAdapter.setItemCallback(new ListItemCallback<Celebrity>() {
            @Override
            public void onListItemClick(View itemView, Celebrity entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                launchCastDetail(entity);
            }

            @Override
            public void onListItemLongClick(View itemView, Celebrity entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {

            }
        });
        mCastListAdapter.setCallback(new CelebrityListAdapter.Callback() {
            @Override
            public void onMoreClick(View view, Celebrity entity, int position) {
                popCastMenu(view, entity);
            }
        });
        mCastsRecyclerView.setAdapter(mCastListAdapter);

        loadCover();

        getPresenter().subscribe(this);
        getPresenter().requestMovieDetail(mMovieSubject.getId());
    }

    private void showMoviePhotos(List<MoviePhoto> photos, int position) {

    }

    private void launchCastDetail(Celebrity entity) {
        Intent intent = new Intent(MovieDetailActivity.this, CommonWebActivity.class);
        intent.putExtra(CommonWebActivity.KEY_EXTRA_URL, entity.getUrl());
        ActivityLauncher.launchWithTransition(MovieDetailActivity.this, intent);
    }

    private void popCastMenu(View anchor, final Celebrity entity) {
        PopupMenu popupMenu = new PopupMenu(MovieDetailActivity.this, anchor);

        Menu menu = popupMenu.getMenu();
        menu.add(1, 1, 1, "加入收藏夹");
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (1 == item.getItemId()) {
                    favoriteCelebrity(entity);
                }
                return true;
            }
        });
        popupMenu.show();
    }

    private View.OnClickListener mSummaryCardClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (ViewUtil.isFastClick()) {
                return;
            }

            mSummaryContentView.setSelected(!mSummaryContentView.isSelected());

            final int duration = 300;
            final int maxLineCollapsed = 3;
            final TimeInterpolator interpolator = new FastOutSlowInInterpolator();

            AutoTransition transition = new AutoTransition();
            transition.setDuration(duration)
                    .setInterpolator(interpolator);

            TransitionManager.beginDelayedTransition(mScrollContentParent, transition);

            if (mSummaryContentView.isSelected()) {
                mSummaryTextView.setMaxLines(Integer.MAX_VALUE);
            } else {
                mSummaryTextView.setMaxLines(maxLineCollapsed);
            }
        }
    };

    private void loadCover() {
        ImageLoader.load(MovieDetailActivity.this, mMovieSubject.getImages().getLarge(), mCoverImageView, false);
    }

    @Override
    public void onRequestDetailSuccess(MovieDetailResponseEntity responseEntity) {
        mMovieDetailResponseEntity = responseEntity;

        if (mMovieDetailResponseEntity != null) {
            List<MovieDetailResponseEntity.CastsBean> casts = responseEntity.getCasts();
            List<MovieDetailResponseEntity.PhotosBean> photos = responseEntity.getPhotos();

            mDurationTextView.setText(responseEntity.getDurations().isEmpty() ? "-" : responseEntity.getDurations().get(0));
            mSummaryTextView.setText(responseEntity.getSummary());

            //Show photos if necessary.
            if (!photos.isEmpty() && mPhotosContentView.getVisibility() != View.VISIBLE) {
                mPhotosContentView.setVisibility(View.VISIBLE);
            }

            //Show casts if necessary.
            if (!casts.isEmpty() && mCastsContentView.getVisibility() != View.VISIBLE) {
                mCastsContentView.setVisibility(View.VISIBLE);
            }

            //Show Rating.
            float rating = (float) responseEntity.getRating().getAverage();
            mRatingTextView.setText(rating > 0 ? String.valueOf(rating) : getString(R.string.no_rating));
            mRatingBar.setProgress((int) rating);

            //Show director.
            MovieDetailResponseEntity.DirectorsBean directorsBean =
                    responseEntity.getDirectors().isEmpty() ? null : responseEntity.getDirectors().get(0);
            if (directorsBean != null) {
                mDirectorTextView.setText(directorsBean.getName());
                MovieDetailResponseEntity.DirectorsBean.AvatarsBeanXX avatar = directorsBean.getAvatars();

                if (avatar != null) {
                    ImageLoader.load(MovieDetailActivity.this, avatar.getLarge(), mDirectorImageView, true, false);
                }
            }

            //Show genres text.
            StringBuilder genresBuilder = new StringBuilder();
            List<String> genres = responseEntity.getGenres();

            for (int i = 0, n = genres.size(); i < n; i++) {
                if (0 == i) {
                    genresBuilder.append(genres.get(0));
                } else {
                    genresBuilder.append(" / ");
                    genresBuilder.append(genres.get(i));
                }
            }
            mGenresTextView.setText(genresBuilder.toString().isEmpty() ? "-" : genresBuilder.toString());

            //Set up photos list data;
            if (!photos.isEmpty()) {
                mPhotoListAdapter.clear();
                List<MoviePhoto> list = new ArrayList<>();

                for (int i = 0, n = photos.size(); i < n; i++) {
                    MovieDetailResponseEntity.PhotosBean photo = photos.get(i);
                    list.add(new MoviePhoto(photo.getCover(), photo.getImage()));
                }
                mPhotoListAdapter.setData(list);
            }

            //Set up casts list data;
            if (!casts.isEmpty()) {
                mCastListAdapter.clear();
                List<Celebrity> list = new ArrayList<>();

                for (int i = 0, n = casts.size(); i < n; i++) {
                    MovieDetailResponseEntity.CastsBean cast = casts.get(i);
                    String avatar = cast.getAvatars() == null ? "" : cast.getAvatars().getMedium();

                    list.add(new Celebrity(cast.getId(), cast.getName(), avatar, cast.getAlt()));
                }
                mCastListAdapter.setData(list);
            }

        }

    }

    @Override
    public void onRequestDetailFailed(String message) {
        showSnackbar("出错了..(" + message + ")");
    }

    @Override
    public void onFavoriteMovieSuccess() {
        showSnackbar(getString(R.string.favorite_success));
    }

    @Override
    public void onFavoriteMovieExists() {
        showSnackbar(getString(R.string.favorite_exist));
    }

    @Override
    protected View provideSnackBarParent() {
        return mFavoriteFAB;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

        if (v == mFavoriteFAB) {
            favoriteMovie();
        }
    }

    private void favoriteMovie() {
        getPresenter().favoriteMovie(mMovieSubject);
    }

    private void favoriteCelebrity(Celebrity entity) {
        getPresenter().favoriteCelebrity(entity);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mFavoriteFAB.setVisibility(View.GONE);
    }


}
