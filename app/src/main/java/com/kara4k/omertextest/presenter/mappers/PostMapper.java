package com.kara4k.omertextest.presenter.mappers;


import com.kara4k.omertextest.model.posts.Post;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class PostMapper implements Function<List<Post>, Observable<Post>> {


    @Inject
    public PostMapper() {
    }

    @Override
    public Observable<Post> apply(@NonNull List<Post> posts) throws Exception {
        return Observable.fromIterable(posts);
    }
}
