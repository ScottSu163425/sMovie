package com.scottsu.smovie.common;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.common
 * 描述:
 * 作者: Su
 * 日期: 2017/8/30 9:34
 **/
public class ImageLoader
{
    public static void load(Context context, String url, ImageView target)
    {
        Glide.with(context)
                .load(url)
                .into(target);
    }
}
