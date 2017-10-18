package com.kara4k.omertextest.presenter.mappers;


import com.kara4k.omertextest.model.photos.Urls;
import com.kara4k.omertextest.model.posts.Post;
import com.kara4k.omertextest.presenter.vo.ReadyPost;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;

public class ReadyPostMapper implements BiFunction<Post, Urls, ReadyPost> {


    @Inject
    public ReadyPostMapper() {
    }

    @Override
    public ReadyPost apply(@NonNull Post post, @NonNull Urls urls) throws Exception {
        ReadyPost readyPost = new ReadyPost();
        readyPost.setId(post.getId());
        readyPost.setUserId(post.getUserId());
        readyPost.setTitle(post.getTitle());
        readyPost.setBody(post.getBody());
        readyPost.setThumbUrl(urls.getThumb());
        readyPost.setPhotoSmallUrl(urls.getSmall());
        return readyPost;
    }


}
