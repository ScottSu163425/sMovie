package com.scottsu.smovie.module.top250;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.data.source.MovieSubject;

/**
 * package: com.scottsu.smovie.module.top250
 * description:
 * author: Su
 * date: 2017/8/27 17:10
 */

public class Top250Fragment extends BaseListFragment<MovieSubject, Top250Contract.View, Top250Contract.Presenter>
        implements Top250Contract.View
{
    private Top250ListAdapter mListAdapter;


    public static Top250Fragment newInstance()
    {
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @NonNull
    @Override
    protected SListAdapter<MovieSubject> provideListAdapter()
    {
        if (mListAdapter == null)
        {
            mListAdapter = new Top250ListAdapter(getContext());
            mListAdapter.setShowEndingFooter(true);
            mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>()
            {
                @Override
                public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
                {
                    Toast.makeText(getContext(), "onListItemClick "+entity.getTitle(), Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames)
                {
                    Toast.makeText(getContext(), "onListItemLongClick " +entity.getTitle(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        return mListAdapter;
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager provideListLayoutManager()
    {
        return null;
    }

    @Override
    protected void onClickEmpty(View view)
    {
        getPresenter().requetListData(getPagingRequestManager().getFirstPage(), getPagingRequestManager().getPageSize(),
                true, false);
    }

    @Override
    protected void onClickError(View view)
    {
        getPresenter().requetListData(getPagingRequestManager().getFirstPage(), getPagingRequestManager().getPageSize(),
            true, false);
    }

    @Override
    protected void onRefresh()
    {
        getPresenter().requetListData(getPagingRequestManager().getFirstPage(), getPagingRequestManager().getPageSize(),
                false, false);
    }

    @Override
    protected void onLoadMore(boolean hasNextPage)
    {
        if (hasNextPage)
        {
            getPresenter().requetListData(getPagingRequestManager().getCurrentPage(), getPagingRequestManager().getPageSize(),
                    false, true);
        }
    }

    @Override
    protected void onListFragmentCreated()
    {
        getPresenter().subscribe(this);

        getPresenter().requetListData(getPagingRequestManager().getFirstPage(), getPagingRequestManager().getPageSize(),
                true, false);
    }

    @Override
    protected Top250Contract.Presenter providePresenter()
    {
        return new Top250Presenter();
    }

}
