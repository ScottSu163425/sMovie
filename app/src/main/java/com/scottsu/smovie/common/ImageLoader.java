package com.scottsu.smovie.common;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.scottsu.smovie.R;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 9:34
 **/
public class ImageLoader
{
    private static final int PLACE_HOLDER_DEFAULT = R.color.md_grey_300;

    public static void load(Context context, String url, ImageView target)
    {
        load(context, url, target,PLACE_HOLDER_DEFAULT,PLACE_HOLDER_DEFAULT );
    }

    public static void load(Context context, String url, ImageView target, int placeHolder, int errorHolder)
    {
        RequestOptions options = new RequestOptions()
                .centerCrop()
                .placeholder(placeHolder)
                .error(errorHolder);

        Glide.with(context)
                .load(url)
                .apply(options)
                .transition(new DrawableTransitionOptions().crossFade())
                .into(target);
    }


}
