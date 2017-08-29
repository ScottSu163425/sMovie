package com.scottsu.smovie.module.top250;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

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
        request(true, false);
    }

    @Override
    public void onRefreshListData()
    {
        getView().turnToFirstPage();

        request(false, false);
    }

    @Override
    public void onLoadMoreListData()
    {
        request(false, true);
    }

    @Override
    public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
    {

    }

    @Override
    public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
    {

    }

    @Override
    public void onClickEmpty()
    {
        request(true, false);
    }

    @Override
    public void onClickError()
    {
        request(true, false);
    }

    private void request(final boolean showLoading, final boolean loadMore)
    {
        if (loadMore && !getView().hasNextPage())
        {
            getView().showNoMoreData();
            return;
        }

        Api.requestTop250(getView().getCurrentPage(), getView().getPageSize())
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

                        getView().fillListData(value.getSubjects(), loadMore);

                        if (list.isEmpty() && !loadMore)
                        {
                            getView().showEmpty();
                        }

                        getView().showContent();

                        int total = value.getTotal();
                        int pageSize = value.getCount();
                        int page = value.getStart();

                        boolean hasNext = ((page + 1) * pageSize) < total;

                        if (hasNext)
                        {
                            getView().turnToNextPage();
                        } else
                        {
                            getView().setLastPage();
                        }
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
