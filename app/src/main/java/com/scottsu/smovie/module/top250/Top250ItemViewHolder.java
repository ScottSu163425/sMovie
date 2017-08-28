package com.scottsu.smovie.module.top250;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.data.source.MovieSubject;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 8:48
 **/
public class Top250ItemViewHolder extends SListViewHolder<MovieSubject>
{
    private TextView mTitleTextView,mYearTextView;


    public Top250ItemViewHolder(View itemView)
    {
        super(itemView);
    }

    public Top250ItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes)
    {
        super(parent, layoutRes);

        mTitleTextView= (TextView) findViewById(R.id.tv_title);
        mYearTextView= (TextView) findViewById(R.id.tv_year);
    }

    @Override
    public void bindData(Context context, MovieSubject entity, int position)
    {
        mTitleTextView.setText(entity.getTitle());
        mYearTextView.setText(entity.getYear());
    }

}
