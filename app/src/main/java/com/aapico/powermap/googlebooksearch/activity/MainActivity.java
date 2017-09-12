package com.aapico.powermap.googlebooksearch.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.aapico.powermap.googlebooksearch.adapter.BookAdapter;
import com.aapico.powermap.googlebooksearch.viewmodel.BookViewModel;
import com.aapico.powermap.googlebooksearch.R;
import com.aapico.powermap.googlebooksearch.dao.Book;
import com.aapico.powermap.googlebooksearch.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends LifecycleActivity {

    BookViewModel bookViewModel;
    ActivityMainBinding binding;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initRecycleView();

        binding.buttonClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {bookViewModel.searchBook("IOS");
            }
        });
    }

    private void initRecycleView() {
        adapter = new BookAdapter();
        binding.listTitle.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        binding.listTitle.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        binding.listTitle.setAdapter(adapter);

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        bookViewModel.getBook().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {adapter.setBooks(books);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}
