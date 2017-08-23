package com.scottsu.smovie.data.source.remote;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 项目: sMovie
 * 包名: com.scottsu.smovie.data.source
 * 描述:
 * 作者: Su
 * 日期: 2017/8/23 16:10
 **/
public class RetrofitClient
{
    private static RetrofitClient sInstance;
    private static final String BASE_URL = "http://api.douban.com/v2/movie/";


    private static OkHttpClient sOkHttpClient;
    private static Retrofit sRetrofit;

    private RetrofitClient()
    {
        sOkHttpClient = new OkHttpClient.Builder()
                .build();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(sOkHttpClient)
                .build();
    }

    public static RetrofitClient getInstance()
    {
        if (sInstance == null)
        {
            synchronized (RetrofitClient.class)
            {
                if (sInstance == null)
                {
                    sInstance = new RetrofitClient();
                }
            }
        }
        return sInstance;
    }

    public <T> T createService(Class<T> service)
    {
        return sRetrofit.create(service);
    }


}
