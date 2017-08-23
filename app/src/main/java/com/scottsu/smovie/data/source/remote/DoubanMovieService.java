package com.scottsu.smovie.data.source.remote;

import com.scottsu.smovie.data.source.HotInTheatersResponseEntity;
import com.scottsu.smovie.data.source.Top250ResponseEntity;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source.remote
 * 描述:
 * 作者: Su
 * 日期: 2017/8/23 16:24
 **/
public interface DoubanMovieService
{

    @FormUrlEncoded
    @POST("in_theaters")
    Observable<HotInTheatersResponseEntity> requestHotInTheaters(@Field("start") int start,
                                                                 @Field("count") int count);

    @FormUrlEncoded
    @POST("top250")
    Observable<Top250ResponseEntity> requestTop250(@Field("start") int start,@Field("count") int count);


}
