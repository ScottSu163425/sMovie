package com.scottsu.smovie.module.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.module.favorites.celebrity.FavoriteCelebrityFragment;
import com.scottsu.smovie.module.favorites.movie.FavoriteMovieFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites
 * description:
 * author: Su
 * date: 2017/9/1 14:56
 */

public class FavoritesActivity extends BaseActivity<FavoritesContract.View, FavoritesContract.Presenter>
        implements FavoritesContract.View {
    public static final String KEY_EXTRA_NEED_TRANSITION = "KEY_EXTRA_NEED_TRANSITION";

    private boolean mNeedTransition;
    private ViewPager mViewPager;
    private FavoriteMovieFragment mFavoriteMovieFragment;
    private FavoriteCelebrityFragment mFavoriteCelebrityFragment;


    @Override
    protected View provideSnackBarParent() {
        return mViewPager;
    }

    @Override
    protected boolean subscribeEvents() {
        return false;
    }

    @Override
    protected int provideContentLayoutRes() {
        return R.layout.activity_favorites;
    }

    @Override
    protected FavoritesContract.Presenter providePresenter() {
        return null;
    }

    @Override
    protected void onActivityCreated(@Nullable Bundle savedInstanceState) {
        mNeedTransition = getIntent().getBooleanExtra(KEY_EXTRA_NEED_TRANSITION, false);
        if (mNeedTransition) {
            if (isLollipop()) {
                getWindow().setEnterTransition(new Explode());
                getWindow().getEnterTransition().addListener(new Transition.TransitionListener() {
                    @Override
                    public void onTransitionStart(Transition transition) {

                    }

                    @Override
                    public void onTransitionEnd(Transition transition) {
                        init();
                    }

                    @Override
                    public void onTransitionCancel(Transition transition) {

                    }

                    @Override
                    public void onTransitionPause(Transition transition) {

                    }

                    @Override
                    public void onTransitionResume(Transition transition) {

                    }
                });
            } else {
                init();
            }
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            init();
        }

    }

    private void init() {
        //Setup toolbar.
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.action_favorite));
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        mFavoriteMovieFragment = FavoriteMovieFragment.newInstance();
        mFavoriteCelebrityFragment = FavoriteCelebrityFragment.newInstance();

        mViewPager = (ViewPager) findViewById(R.id.vp);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        List<Fragment> fragments = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        fragments.add(mFavoriteMovieFragment);
        fragments.add(mFavoriteCelebrityFragment);
        titles.add(getString(R.string.favorite_movie));
        titles.add(getString(R.string.favorite_celebrity));
        FavoritesPagerAdapter pagerAdapter = new FavoritesPagerAdapter(getSupportFragmentManager(),
                fragments, titles);

        mViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!mNeedTransition) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }


}
