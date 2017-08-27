package com.scottsu.smovie.module.main;

import android.support.annotation.NonNull;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;

/**
 * package: com.scottsu.smovie.module.main
 * description:
 * author: Su
 * date: 2017/8/27 11:06
 */

public class MainPresenter extends BaseMvpPresenter<MainContract.View>
        implements MainContract.Presenter {

    public MainPresenter(@NonNull MainContract.View view) {
        super(view);
    }

    @Override
    public void onViewAttached() {

    }

    @Override
    public void onActionSearchClick() {
        getView().openSearch();
    }

}
