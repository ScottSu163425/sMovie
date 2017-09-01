package com.scottsu.smovie.module.favorites;

import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites
 * description:
 * author: Su
 * date: 2017/9/1 14:56
 */

public interface FavoritesContract {
    interface View extends IMvpView {

    }

    interface Presenter extends IMvpPresenter<FavoritesContract.View> {

    }

}
