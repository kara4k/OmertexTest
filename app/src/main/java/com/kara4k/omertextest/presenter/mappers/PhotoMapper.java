package com.kara4k.omertextest.presenter.mappers;


import com.kara4k.omertextest.model.photos.Response;
import com.kara4k.omertextest.model.photos.Urls;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class PhotoMapper implements Function<Response, Observable<Urls>> {

    @Inject
    public PhotoMapper() {
    }

    @Override
    public Observable<Urls> apply(@NonNull Response response) throws Exception {
        return Observable.just(response).map(r -> r.getResults())
                .flatMapIterable(results -> results)
                .map(result -> result.getUrls());
    }
}
