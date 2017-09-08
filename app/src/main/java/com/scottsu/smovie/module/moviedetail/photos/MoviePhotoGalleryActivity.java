package com.scottsu.smovie.module.moviedetail.photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;

import com.jaeger.library.StatusBarUtil;
import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.common.ImageLoader;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.moviedetail.photos
 * description:
 * author: Su
 * date: 2017/9/8 14:48
 */

public class MoviePhotoGalleryActivity extends BaseActivity {
    public static final String KEY_EXTRA_PHOTOS = "KEY_EXTRA_PHOTOS";
    public static final String KEY_EXTRA_POSITION = "KEY_EXTRA_POSITION";

    private RecyclerView mRecyclerView;
    private MoviePhotoGalleryListAdapter mListAdapter;


    @Override
    protected View provideSnackBarParent() {
        return null;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_movie_photo_gallery;
    }

    @Override
    protected IMvpPresenter providePresenter() {
        return null;
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        List<MoviePhoto> photos = (List<MoviePhoto>) getIntent().getSerializableExtra(KEY_EXTRA_PHOTOS);
        int position = getIntent().getIntExtra(KEY_EXTRA_POSITION, -1);

        if (photos == null || position == -1) {
            finish();
        }

        if (isLollipop()) {
            getWindow().setEnterTransition(new Fade());
        }

        StatusBarUtil.setTranslucentForImageView(MoviePhotoGalleryActivity.this, 30, null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_photos);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(MoviePhotoGalleryActivity.this,
                LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.setHasFixedSize(true);
        new PagerSnapHelper().attachToRecyclerView(mRecyclerView);

        mListAdapter = new MoviePhotoGalleryListAdapter(MoviePhotoGalleryActivity.this, photos);
        mRecyclerView.setAdapter(mListAdapter);
        mRecyclerView.scrollToPosition(position);
    }


}
