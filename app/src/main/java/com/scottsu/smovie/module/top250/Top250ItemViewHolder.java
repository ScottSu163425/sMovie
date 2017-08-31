package com.scottsu.smovie.module.top250;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.haozhang.lib.SlantedTextView;
import com.scottsu.slist.library.adapter.viewholder.SListViewHolder;
import com.scottsu.smovie.R;
import com.scottsu.smovie.common.ImageLoader;
import com.scottsu.smovie.data.source.MovieSubject;
import com.scottsu.utils.ViewUtil;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.module.top250
 * 描述:
 * 作者: Su
 * 日期: 2017/8/28 8:48
 **/
public class Top250ItemViewHolder extends SListViewHolder<MovieSubject>
{
    private ImageView mCoverImageView;
    private TextView mTitleTextView, mYearTextView, mRatingTextView;
    private RatingBar mRatingBar;
    private SlantedTextView mRankingSlantedTextView;


    public Top250ItemViewHolder(View itemView)
    {
        super(itemView);
    }

    public Top250ItemViewHolder(ViewGroup parent, @LayoutRes int layoutRes)
    {
        super(parent, layoutRes);

        mCoverImageView = (ImageView) findViewById(R.id.iv_cover);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mYearTextView = (TextView) findViewById(R.id.tv_year);
        mRatingTextView = (TextView) findViewById(R.id.tv_rating);
        mRatingBar = (RatingBar) findViewById(R.id.rating_bar_rating);
        mRankingSlantedTextView = (SlantedTextView) findViewById(R.id.slanted_view_ranking);
    }

    @Override
    public void bindData(Context context, MovieSubject entity, int position)
    {
        ImageLoader.load(context, entity.getImages().getLarge(), mCoverImageView);
        mTitleTextView.setText(entity.getTitle());
        mYearTextView.setText(entity.getYear());
        mRatingTextView.setText(String.valueOf(entity.getRating().getAverage()));
        mRatingBar.setProgress((int) entity.getRating().getAverage());

        if (3 > position)
        {
            //Top 3.
            ViewUtil.setViewVisible(mRankingSlantedTextView);

            if (0 == position)
            {
                mRankingSlantedTextView.setSlantedBackgroundColor(ContextCompat.getColor(context, R.color.ranking_1st));
                mRankingSlantedTextView.setText(context.getString(R.string.tag_ranking_1st));
            } else if (1 == position)
            {
                mRankingSlantedTextView.setSlantedBackgroundColor(ContextCompat.getColor(context, R.color.ranking_2nd));
                mRankingSlantedTextView.setText(context.getString(R.string.tag_ranking_2nd));
            } else if (2 == position)
            {
                mRankingSlantedTextView.setSlantedBackgroundColor(ContextCompat.getColor(context, R.color.ranking_3rd));
                mRankingSlantedTextView.setText(context.getString(R.string.tag_ranking_3rd));
            }
        } else
        {
            ViewUtil.setViewGone(mRankingSlantedTextView);
        }

    }

}
