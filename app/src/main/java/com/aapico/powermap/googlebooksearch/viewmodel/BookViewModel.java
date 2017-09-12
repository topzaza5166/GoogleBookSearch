package com.aapico.powermap.googlebooksearch.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.aapico.powermap.googlebooksearch.api.HttpManager;
import com.aapico.powermap.googlebooksearch.dao.Book;
import com.aapico.powermap.googlebooksearch.dao.BookSearchResult;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Copyright 2017-present, AAPICO ITS Co., Ltd. All rights reserved.
 * <p>
 * Project      : [SC#A] SmartCity - Amata
 * Author       : teepop.r@aapico.com
 * Date Create  : 12/7/2016 AD
 **/
public class BookViewModel extends ViewModel {

    private MutableLiveData<List<Book>> booksLiveData;

    public BookViewModel() {
    }

    public void searchBook(String keyword) {
        Call<BookSearchResult> call = HttpManager.getInstance().getBookService().search(keyword);
        call.enqueue(new Callback<BookSearchResult>() {
            @Override
            public void onResponse(Call<BookSearchResult> call, Response<BookSearchResult> response) {
                if (response.isSuccessful()) {
                    booksLiveData.postValue( response.body().getBooks());
                    Log.d("response", "Response Successful : " + response.body().getBooks().size() + " items");
                } else try {
                    Log.d("response", "Response Error: " + response.errorBody().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(Call<BookSearchResult> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<List<Book>> getBook() {
        if (booksLiveData == null) {
            booksLiveData = new MutableLiveData<>();
            searchBook("Android");
        }
        return booksLiveData;
    }

}
