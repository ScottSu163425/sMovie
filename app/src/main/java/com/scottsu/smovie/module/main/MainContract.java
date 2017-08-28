package com.scottsu.smovie.module.main;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;

/**
 * package: com.scottsu.smovie.module.main
 * description:
 * author: Su
 * date: 2017/8/27 11:03
 */

public interface MainContract
{

    interface View extends IMvpView
    {
        void openDrawer();

        void closeDrawer();

        void openSearch();
    }

    interface Presenter extends IMvpPresenter<MainContract.View>
    {
        void onActionSearchClick();
    }
}
