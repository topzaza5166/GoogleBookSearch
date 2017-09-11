package com.aapico.powermap.googlebooksearch;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aapico.powermap.googlebooksearch.dao.Book;
import com.aapico.powermap.googlebooksearch.databinding.BookListItemBinding;

import java.util.List;

/**
 * Copyright 2017-present, AAPICO ITS Co., Ltd. All rights reserved.
 * <p>
 * Project      : [SC#A] SmartCity - Amata
 * Author       : teepop.r@aapico.com
 * Date Create  : 12/7/2016 AD
 **/
public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookItemViewHolder> {

    private List<Book> books;

    @Override
    public BookItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.book_list_item, parent, false);
        return new BookItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookItemViewHolder holder, int position) {
        Book book = books.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public class BookItemViewHolder extends RecyclerView.ViewHolder {

        private BookListItemBinding binding;

        public BookItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public void bind(Book book) {
            binding.setBookSaleInfo(book.getSaleInfo());
            binding.setBookVolumeInfo(book.getVolumeInfo());
        }
    }
}


