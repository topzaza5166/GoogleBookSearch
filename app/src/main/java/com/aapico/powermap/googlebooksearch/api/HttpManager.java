package com.aapico.powermap.googlebooksearch.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Copyright 2017-present, AAPICO ITS Co., Ltd. All rights reserved.
 * <p>
 * Project      : [SC#A] SmartCity - Amata
 * Author       : teepop.r@aapico.com
 * Date Create  : 12/7/2016 AD
 **/
public class HttpManager {
    private static final HttpManager ourInstance = new HttpManager();
    private final BookService bookService;

    public static HttpManager getInstance() {
        return ourInstance;
    }

    private HttpManager() {

        Gson gson = new GsonBuilder()
                        .setDateFormat("yyyy-mm-dd")
                        .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.googleapis.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        bookService = retrofit.create(BookService.class);
    }

    public BookService getBookService() {
        return bookService;
    }
}
