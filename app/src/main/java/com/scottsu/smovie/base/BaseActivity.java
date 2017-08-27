package com.scottsu.smovie.base;

import com.scottsu.library.mvp.activity.MvpActivity;
import com.scottsu.library.mvp.presenter.IMvpPresenter;
import com.scottsu.library.mvp.view.IMvpView;

/**
 * package: com.scottsu.smovie.base
 * description:
 * author: Su
 * date: 2017/8/27 11:01
 */

public abstract class BaseActivity<V extends IMvpView, P extends IMvpPresenter<V>>
        extends MvpActivity<V, P> {
}
