package com.aapico.powermap.googlebooksearch.api;

import com.aapico.powermap.googlebooksearch.dao.BookSearchResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Copyright 2017-present, AAPICO ITS Co., Ltd. All rights reserved.
 * <p>
 * Project      : [SC#A] SmartCity - Amata
 * Author       : teepop.r@aapico.com
 * Date Create  : 12/7/2016 AD
 **/
public interface BookService {

    @GET("books/v1/volumes")
    Call<BookSearchResult> search(@Query("q") String keyword);

}
