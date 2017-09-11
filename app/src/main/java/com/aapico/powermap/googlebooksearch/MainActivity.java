package com.aapico.powermap.googlebooksearch;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.aapico.powermap.googlebooksearch.dao.Book;
import com.aapico.powermap.googlebooksearch.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends LifecycleActivity {

    BookViewModel bookViewModel;
    ActivityMainBinding binding;
    BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);
        bookViewModel.getBook().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(@Nullable List<Book> books) {
                adapter = new BookAdapter();
                binding.listTitle.setAdapter(adapter);
                adapter.setBooks(books);
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, adapter.getItemCount() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}
