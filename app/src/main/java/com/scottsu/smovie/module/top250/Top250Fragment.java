package com.scottsu.smovie.module.top250;


import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.R;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.common.events.ListDraggingEvent;
import com.scottsu.smovie.common.events.ListReleasedEvent;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.scottsu.smovie.module.moviedetail.MovieDetailActivity;
import com.scottsu.utils.ActivityLauncher;

import org.greenrobot.eventbus.EventBus;

/**
 * package: com.scottsu.smovie.module.top250
 * description:
 * author: Su
 * date: 2017/8/27 17:10
 */

public class Top250Fragment extends BaseListFragment<MovieSubject, Top250Contract.View, Top250Contract.Presenter>
        implements Top250Contract.View {

    private Top250ListAdapter mListAdapter;


    public static Top250Fragment newInstance() {
        Top250Fragment fragment = new Top250Fragment();
        return fragment;
    }

    @NonNull
    @Override
    protected SListAdapter<MovieSubject> provideListAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new Top250ListAdapter(getContext());
            mListAdapter.setShowEndingFooter(true);
            mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>() {
                @Override
                public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    launchMovieDetail(entity, sharedElements, transitionNames);
                }

                @Override
                public void onListItemLongClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                }
            });
        }
        return mListAdapter;
    }

    @Nullable
    @Override
    protected RecyclerView.LayoutManager provideListLayoutManager() {
        return null;
    }

    @Override
    protected int getListPadding() {
        return getResources().getDimensionPixelSize(R.dimen.padding_s);
    }

    @Override
    protected void onClickEmpty(View view) {
        requestListData(true, false);
    }

    @Override
    protected void onClickError(View view) {
        requestListData(true, false);
    }

    @Override
    protected void onRefresh() {
        requestListData(false, false);
    }

    @Override
    protected void onLoadMore(boolean hasNextPage) {
        if (hasNextPage) {
            requestListData(false, true);
        }
    }

    @Override
    protected void onListFragmentCreated() {
        getPresenter().subscribe(this);

        requestListData(true, false);
    }

    @Override
    protected Top250Contract.Presenter providePresenter() {
        return new Top250Presenter();
    }

    @Override
    protected void onListDragging() {
        super.onListDragging();

        EventBus.getDefault().post(new ListDraggingEvent());
    }

    @Override
    protected int getDefaultStateBackgroundColor() {
        return Color.TRANSPARENT;
    }

    @Override
    protected void onListReleased() {
        super.onListReleased();

        EventBus.getDefault().post(new ListReleasedEvent());
    }

    @Override
    protected boolean subscribeEvents() {
        return false;
    }

    private void requestListData(boolean showLoading, boolean loadMore) {
        getPresenter().requestListData(loadMore ? getPagingRequestManager().getCurrentIndex()
                        : getPagingRequestManager().getFirstIndex(),
                getPagingRequestManager().getPageSize(),
                showLoading, loadMore);
    }

    private void launchMovieDetail(MovieSubject entity, View[] sharedElements, String[] transitionNames) {
        Intent intent = new Intent(getActivity(), MovieDetailActivity.class);
        intent.putExtra(MovieDetailActivity.KEY_EXTRA_MOVIE_SUBJECT, entity);

        ActivityLauncher.launchWithSharedElement(getActivity(), intent, sharedElements[0], transitionNames[0]);
    }

}
