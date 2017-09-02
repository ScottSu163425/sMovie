package com.scottsu.smovie.module.top250;

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
import com.scottsu.smovie.module.hot.HotItemViewHolder;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 11:29
 **/
public class Top250ListAdapter extends SListAdapter<MovieSubject>
        implements FastScrollRecyclerView.SectionedAdapter {
    public Top250ListAdapter(Context context) {
        super(context);
    }

    public Top250ListAdapter(Context context, List<MovieSubject> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return false;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType) {
        return new Top250ItemViewHolder(parent, R.layout.item_top250);
    }

    @Override
    protected void onBindVH(SListViewHolder<MovieSubject> holder, final MovieSubject entity, final int position) {
        holder.bindData(getContext(), entity, position);

        final Top250ItemViewHolder viewHolder = (Top250ItemViewHolder) holder;
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
