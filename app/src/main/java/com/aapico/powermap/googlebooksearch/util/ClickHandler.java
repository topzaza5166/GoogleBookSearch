package com.aapico.powermap.googlebooksearch.util;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.aapico.powermap.googlebooksearch.dao.Book;

/**
 * Copyright 2017-present, AAPICO ITS Co., Ltd. All rights reserved.
 * <p>
 * Project      : [SC#A] SmartCity - Amata
 * Author       : teepop.r@aapico.com
 * Date Create  : 12/7/2016 AD
 **/
public class ClickHandler {
    private final Book book;

    public ClickHandler(Book book) {
        this.book = book;
    }

    public void onClick(View view) {
        Toast.makeText(view.getContext(), book.getVolumeInfo().getTitle(), Toast.LENGTH_SHORT).show();
    }
}
