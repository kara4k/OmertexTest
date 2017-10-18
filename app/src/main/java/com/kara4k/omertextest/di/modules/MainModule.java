package com.kara4k.omertextest.di.modules;

import com.kara4k.omertextest.api.PhotoApi;
import com.kara4k.omertextest.api.PostsApi;
import com.kara4k.omertextest.di.scopes.PerActivity;
import com.kara4k.omertextest.view.IMainView;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class MainModule {

    private IMainView mIMainView;

    public MainModule(IMainView IMainView) {
        mIMainView = IMainView;
    }

    @PerActivity
    @Provides
    IMainView provideMainView() {
        return mIMainView;
    }

    @Provides
    @PerActivity
    PostsApi provideUserApi(@Named(AppModule.POSTS) Retrofit retrofit) {
        return retrofit.create(PostsApi.class);
    }

    @Provides
    @PerActivity
    PhotoApi providePhotoApi(@Named(AppModule.PHOTOS)Retrofit retrofit) {
        return retrofit.create(PhotoApi.class);
    }
}
