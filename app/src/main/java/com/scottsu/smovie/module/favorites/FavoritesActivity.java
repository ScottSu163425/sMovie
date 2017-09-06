package com.scottsu.smovie.module.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Explode;
import android.transition.Transition;
import android.widget.Toast;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.data.source.local.FavoriteCelebrityRepository;
import com.scottsu.smovie.module.favorites.movie.FavoriteMovieFragment;

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
    private FavoriteMovieFragment mFavoriteMovieFragment;


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
            }
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        if (isLollipop()) {
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
        }

    }

    private void init() {
        mFavoriteMovieFragment = FavoriteMovieFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container, mFavoriteMovieFragment)
                .commit();

        Toast.makeText(FavoritesActivity.this, new FavoriteCelebrityRepository().queryAll().size() + "", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (!mNeedTransition) {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }
    }


}
