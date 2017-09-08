package com.scottsu.smovie.module.favorites.celebrity;

import com.scottsu.library.mvp.presenter.IListPresenter;
import com.scottsu.smovie.base.BaseListView;
import com.scottsu.smovie.module.moviedetail.celebrity.Celebrity;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.celebrity
 * description:
 * author: Su
 * date: 2017/9/7 9:53
 */

public interface FavoriteCelebrityContract {
    interface View extends BaseListView<Celebrity> {
        void onMovieRemoved(Celebrity celebrity, int position);
    }

    interface Presenter extends IListPresenter<Celebrity, FavoriteCelebrityContract.View> {
        void removeMovie(Celebrity celebrity, int position);
    }


}
