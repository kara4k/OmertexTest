package com.kara4k.omertextest.api;


import com.kara4k.omertextest.model.posts.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostsApi {

    @GET("/posts?_start=1&_limit=30")
    Observable<List<Post>> getPosts();

}
