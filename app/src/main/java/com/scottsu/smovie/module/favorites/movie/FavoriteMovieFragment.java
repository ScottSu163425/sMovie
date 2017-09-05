package com.scottsu.smovie.module.favorites.movie;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.interfaces.ListItemCallback;
import com.scottsu.smovie.base.BaseListFragment;
import com.scottsu.smovie.data.enity.MovieSubject;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/5 20:56
 */

public class FavoriteMovieFragment
        extends BaseListFragment<MovieSubject, FavoriteMovieContract.View, FavoriteMovieContract.Presenter>
        implements FavoriteMovieContract.View {

    private FavoriteMovieListAdapter mListAdapter;

    public static FavoriteMovieFragment newInstance() {
        FavoriteMovieFragment fragment = new FavoriteMovieFragment();
        return fragment;
    }

    @Override
    protected boolean subscribeEvents() {
        return false;
    }

    @NonNull
    @Override
    protected SListAdapter<MovieSubject> provideListAdapter() {
        if (mListAdapter == null) {
            mListAdapter = new FavoriteMovieListAdapter(getContext());
            mListAdapter.setItemCallback(new ListItemCallback<MovieSubject>() {
                @Override
                public void onListItemClick(View itemView, MovieSubject entity, int position, @Nullable View[] sharedElements, @Nullable String[] transitionNames) {
                    Toast.makeText(getContext(), entity.getTitle(), Toast.LENGTH_SHORT).show();
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
    protected void onClickEmpty(View view) {

    }

    @Override
    protected void onClickError(View view) {

    }

    @Override
    protected void onRefresh() {

    }

    @Override
    protected void onLoadMore(boolean hasNextPage) {

    }

    @Override
    protected void onListFragmentCreated() {

        getPresenter().subscribe(this);
        getPresenter().requestListData(0, 0, true, false);
    }

    @Override
    protected FavoriteMovieContract.Presenter providePresenter() {
        return new FavoriteMoviePresenter();
    }

    @Override
    protected boolean enableSwipeRefresh() {
        return false;
    }

    @Override
    protected boolean enableLoadMore() {
        return false;
    }


}
