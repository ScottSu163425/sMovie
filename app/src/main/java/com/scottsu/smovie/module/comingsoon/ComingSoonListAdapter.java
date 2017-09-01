package com.scottsu.smovie.module.comingsoon;

import android.content.Context;
import android.view.ViewGroup;

import com.scottsu.slist.library.adapter.SListAdapter;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.smovie.module.hot.HotItemViewHolder;

import java.util.List;

/**
 * project: sMovie
 * package: com.scottsu.smovie.module.comingsoon
 * description:
 * author: Su
 * date: 2017/9/1 9:24
 */

public class ComingSoonListAdapter extends SListAdapter<MovieSubject>
{
    public ComingSoonListAdapter(Context context)
    {
        super(context);
    }

    public ComingSoonListAdapter(Context context, List<MovieSubject> dataList)
    {
        super(context, dataList);
    }

    @Override
    protected boolean autoRegisterItemCallback()
    {
        return true;
    }

    @Override
    protected SListViewHolder<MovieSubject> onCreateVH(ViewGroup parent, int viewType)
    {
        return new ComingSoonItemViewHolder(parent, R.layout.item_1);
    }

    @Override
    protected void onBindVH(SListViewHolder<MovieSubject> holder, MovieSubject entity, int position)
    {
        holder.bindData(getContext(), entity, position);
    }


}
