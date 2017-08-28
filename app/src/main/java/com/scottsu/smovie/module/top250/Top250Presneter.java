package com.scottsu.smovie.module.top250;

import android.support.annotation.NonNull;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 11:46
 **/
public class Top250Presneter extends BaseMvpPresenter<Top250Contract.View>
        implements Top250Contract.Presenter
{
    public Top250Presneter(@NonNull Top250Contract.View view)
    {
        super(view);
    }

    @Override
    public void onViewAttached()
    {

    }
}
