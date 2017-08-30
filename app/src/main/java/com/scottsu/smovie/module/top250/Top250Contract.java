package com.scottsu.smovie.module.top250;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.library.mvp.view.IListView;
import com.scottsu.smovie.base.BaseListView;
import com.scottsu.smovie.base.BaseView;
import com.scottsu.smovie.data.source.MovieSubject;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 11:38
 **/
public interface Top250Contract
{
    interface View extends BaseListView<MovieSubject>
    {

    }

    interface Presenter extends IListPresenter<MovieSubject, View>
    {

    }


}
