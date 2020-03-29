package com.example.retrofitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsViewModel postsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        postsViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.rv);

        final ListAdapter listAdapter = new ListAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
        postsViewModel.listMutableLiveData.observe(this, new Observer<List<Posts>>() {
            @Override
            public void onChanged(List<Posts> posts) {
                listAdapter.setList(posts);
            }
        });


    }
}
