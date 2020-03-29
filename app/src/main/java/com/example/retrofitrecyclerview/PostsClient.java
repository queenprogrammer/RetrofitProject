package com.example.retrofitrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static PostsClient INSTANCE;
    private PostsInterface postsInterface;

    public PostsClient() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postsInterface = retrofit.create(PostsInterface.class);

    }

    public static PostsClient getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<Posts>> getAllPosts() {
        return postsInterface.getAllPosts();
    }
}
