package com.scottsu.smovie.module.favorites.movie;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.favorites.movie
 * description:
 * author: Su
 * date: 2017/9/5 20:58
 */

public class FavoriteMovieListAdapter extends SListAdapter<MovieSubject>
        implements FastScrollRecyclerView.SectionedAdapter {

    public FavoriteMovieListAdapter(Context context) {
        super(context);
    }

    public FavoriteMovieListAdapter(Context context, List<MovieSubject> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return false;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType) {
        return new FavoriteMovieListViewHolder(parent, R.layout.item_movie_subject_commom);
    }

    @Override
    protected void onBindVH(final SListViewHolder<MovieSubject> holder, final MovieSubject entity, final int position) {
        holder.bindData(getContext(), entity, position);

        final FavoriteMovieListViewHolder viewHolder = (FavoriteMovieListViewHolder) holder;
        final ImageView sharedElement = viewHolder.getCoverImageView();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getItemCallback().onListItemClick(view, entity, position,
                        new View[]{sharedElement},
                        new String[]{ViewCompat.getTransitionName(sharedElement)});
            }
        });
    }

    @NonNull
    @Override
    public String getSectionName(int position) {
        if (isFooterShown() && position == getItemCount() - 1) {
            return "";
        }
        return getData(position).getTitle().substring(0, 1);
    }

}