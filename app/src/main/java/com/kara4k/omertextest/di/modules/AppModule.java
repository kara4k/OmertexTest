package com.kara4k.omertextest.di.modules;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    public static final String POSTS_ENDPOINT = "https://jsonplaceholder.typicode.com";
    public static final String PHOTOS_ENDPOINT = "https://api.unsplash.com";

    public static final String POSTS = "posts";
    public static final String PHOTOS = "photos";

    Context mContext;

    public AppModule(Context context) {
        mContext = context;
    }

    @Singleton
    @Provides
    Context provideContext() {
        return mContext;
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient1() {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    @Named(POSTS)
    Retrofit providePostsRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(POSTS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    @Named(PHOTOS)
    Retrofit providePhotosRetrofit(OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(PHOTOS_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }
}
