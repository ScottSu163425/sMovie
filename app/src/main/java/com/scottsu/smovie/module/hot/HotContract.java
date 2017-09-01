package com.scottsu.smovie.module.hot;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.smovie.base.BaseListView;
import com.scottsu.smovie.data.source.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.hot
 * description:
 * author: Su
 * date: 2017/9/1 8:01
 */

public interface HotContract {
    interface View extends BaseListView<MovieSubject> {

    }

    interface Presenter extends IListPresenter<MovieSubject, HotContract.View> {

    }
}
