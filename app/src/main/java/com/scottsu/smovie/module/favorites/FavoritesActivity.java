package com.scottsu.smovie.module.favorites;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseActivity;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.data.source.local.FavoriteMovieRepository;

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

        List<MovieSubject> movieSubjects = new FavoriteMovieRepository().queryAll();
    }


}
