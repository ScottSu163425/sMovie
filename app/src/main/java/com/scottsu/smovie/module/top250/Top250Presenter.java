package com.scottsu.smovie.module.top250;

import android.util.Log;

import com.scottsu.library.mvp.presenter.BaseMvpPresenter;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.smovie.data.source.Top250ResponseEntity;
import com.scottsu.smovie.data.source.remote.Api;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 11:46
 **/
public class Top250Presenter extends BaseMvpPresenter<Top250Contract.View>
        implements Top250Contract.Presenter
{

    @Override
    public void onViewSubscribed()
    {

    }

    @Override
    public void requetListData(int startPage, int pageSize, final boolean showLoading, final boolean loadMore)
    {
        if(!getView().checkConnection()){
                return;
        }

        Api.requestTop250(startPage, pageSize)
                .subscribe(new Observer<Top250ResponseEntity>()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                        if (showLoading)
                        {
                            getView().showLoading();
                        }
                    }

                    @Override
                    public void onNext(Top250ResponseEntity value)
                    {
                        List<MovieSubject> list = value.getSubjects();

                        if (list.isEmpty())
                        {
                            if (!loadMore)
                            {
                                getView().showEmpty();
                            }
                        } else
                        {
                            getView().showContent();
                        }

                        getView().showListData(value.getSubjects(), loadMore, value.hasNextPage());
                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        getView().showError();
                    }

                    @Override
                    public void onComplete()
                    {

                    }
                });
    }
}
