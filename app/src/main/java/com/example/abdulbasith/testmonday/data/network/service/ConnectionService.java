package com.example.abdulbasith.testmonday.data.network.service;

import com.example.abdulbasith.testmonday.MyApp;
import com.example.abdulbasith.testmonday.data.network.API_Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Abdul Basith on 20/11/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;

    public static IRequestInterface getConnectionService(){
        okHttpClient = buildClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(IRequestInterface.class);
    }

    private static OkHttpClient buildClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor).build();

        builder.addNetworkInterceptor(new Offline_CacheData.ResponseCacheInterceptor());
        builder.addInterceptor(new Offline_CacheData.OfflineResponseCacheInterceptor())
        .cache(new okhttp3.Cache(new File(MyApp
        .getContext().getCacheDir(),
                "apiResponses"), 5 * 1024 * 1024));
        return new OkHttpClient();
    }
}
