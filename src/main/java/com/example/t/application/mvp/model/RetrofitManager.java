package com.example.t.application.mvp.model;

import android.os.Environment;

import com.example.t.application.constants.Constants;
import com.example.t.application.global.MyApplication;
import com.example.t.application.util.SDCardUtil;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 爱生活，爱代码
 * 创建于：2018/10/24 15:26
 * 作 者：T
 * 微信：704003376
 */
public class RetrofitManager {
    private static final long MAX_CACHE_SIZE = 1024 * 1024 * 10;
    private static RetrofitManager manager;
    private Retrofit mRetrotit;

    private RetrofitManager() {
        init();
    }

    private void init() {
        File file = null;
        if (SDCardUtil.siAvaliable(MAX_CACHE_SIZE)) {
            // storage/sdcard/cache
            file = new File(Environment.getExternalStorageDirectory(), "cache");
        } else {
            file = new File(MyApplication.mCtontext.getCacheDir(), "");
        }
        Cache cache = new Cache(file, MAX_CACHE_SIZE);
        OkHttpClient.Builder builder = new OkHttpClient.Builder().
                cache(cache).connectTimeout(15, TimeUnit.SECONDS).
                readTimeout(10, TimeUnit.SECONDS).
                retryOnConnectionFailure(true);
        mRetrotit = new Retrofit.Builder().baseUrl(Constants.BASE_URL).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                addConverterFactory(GsonConverterFactory.create()).
                client(builder.build()).build();

    }


    public static synchronized RetrofitManager getManagerInstance() {
        if (manager == null) {
            synchronized (RetrofitManager.class) {
                if (manager == null) {
                    manager = new RetrofitManager();
                }
            }
        }
        return manager;
    }


    public APIServicde
    getApiService() {
        return mRetrotit.create(APIServicde.class);
    }

}
