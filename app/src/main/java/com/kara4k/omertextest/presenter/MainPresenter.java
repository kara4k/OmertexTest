package com.kara4k.omertextest.presenter;


import android.content.Context;

import com.kara4k.omertextest.R;
import com.kara4k.omertextest.api.PhotoApi;
import com.kara4k.omertextest.api.PostsApi;
import com.kara4k.omertextest.model.photos.Urls;
import com.kara4k.omertextest.model.posts.Post;
import com.kara4k.omertextest.presenter.mappers.PhotoMapper;
import com.kara4k.omertextest.presenter.mappers.PostMapper;
import com.kara4k.omertextest.presenter.mappers.ReadyPostMapper;
import com.kara4k.omertextest.presenter.vo.ReadyPost;
import com.kara4k.omertextest.view.IMainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter implements SingleObserver<List<ReadyPost>> {

    @Inject
    PostsApi mPostsApi;
    @Inject
    PhotoApi mPhotosApi;

    @Inject
    IMainView mMainView;

    @Inject
    Context mContext;

    @Inject
    ReadyPostMapper mReadyPostMapper;
    @Inject
    PostMapper mPostMapper;
    @Inject
    PhotoMapper mPhotoMapper;

    private CompositeDisposable mCompositeDisposable;


    @Inject
    public MainPresenter() {
        mCompositeDisposable = new CompositeDisposable();
    }

    public void onStart() {
        mMainView.onShowDialog(mContext.getString(R.string.dialog_loading));

        Observable<Post> postsObservable = mPostsApi.getPosts().flatMap(mPostMapper);
        Observable<Urls> photosObservable = mPhotosApi.getPhotos().flatMap(mPhotoMapper);

        Observable.zip(postsObservable, photosObservable, mReadyPostMapper)
                .toList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }

    @Override
    public void onSubscribe(@NonNull Disposable d) {
mCompositeDisposable.add(d);
    }

    @Override
    public void onSuccess(@NonNull List<ReadyPost> readyPosts) {
        mMainView.onHideDialog();
        mMainView.setList(readyPosts);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        mMainView.onHideDialog();
        mMainView.onShowMessage(e.getMessage());
    }

    public void onDestroy() {
        mCompositeDisposable.dispose();
    }
}
