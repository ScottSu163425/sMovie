package com.scottsu.smovie.module.comingsoon;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.enity.MovieSubject;
import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.comingsoon
 * description:
 * author: Su
 * date: 2017/9/1 9:24
 */

public class ComingSoonListAdapter extends SListAdapter<MovieSubject>
        implements FastScrollRecyclerView.SectionedAdapter {
    public ComingSoonListAdapter(Context context) {
        super(context);
    }

    public ComingSoonListAdapter(Context context, List<MovieSubject> dataList) {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback() {
        return true;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType) {
        return new ComingSoonItemViewHolder(parent, R.layout.item_hot);
    }

    @Override
    protected void onBindVH(SListViewHolder<MovieSubject> holder, MovieSubject entity, int position) {
        holder.bindData(getContext(), entity, position);
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
