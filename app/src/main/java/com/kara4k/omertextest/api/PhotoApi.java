package com.kara4k.omertextest.api;


import com.kara4k.omertextest.model.photos.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PhotoApi {

    @GET("/search/photos/?client_id=73e7eeecadbcc72ac5ce1979049a4add4ffdae42bdf06f1c45bea37e31359b62&query=car&per_page=30")
    Observable<Response> getPhotos();
}
