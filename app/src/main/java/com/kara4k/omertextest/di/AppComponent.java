package com.kara4k.omertextest.di;

import android.content.Context;

import com.kara4k.omertextest.di.modules.AppModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context shareContext();

    @Named(AppModule.PHOTOS)
    Retrofit sharePhotosRetrofit();

    @Named(AppModule.POSTS)
    Retrofit sharePostsRetrofit();
}
