package com.scottsu.smovie.module.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.transition.Slide;
import android.view.Gravity;
import android.widget.Toast;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.data.source.local.FavoriteMovieRepository;
import com.scottsu.smovie.module.favorites.movie.FavoriteMovieFragment;

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
        if (getIntent().getBooleanExtra(KEY_EXTRA_NEED_TRANSITION, false)) {
            if (isLollipop()) {
                getWindow().setEnterTransition(new Slide(Gravity.RIGHT));
            }
        } else {
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }

        mFavoriteMovieFragment = FavoriteMovieFragment.newInstance();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fl_container,mFavoriteMovieFragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }


}
