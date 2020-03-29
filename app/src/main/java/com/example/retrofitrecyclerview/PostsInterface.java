package com.example.retrofitrecyclerview;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {

    @GET("posts")
    Call<List<Posts>> getAllPosts();
}
