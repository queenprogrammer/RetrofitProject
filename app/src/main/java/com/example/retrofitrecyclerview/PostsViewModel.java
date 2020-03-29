package com.example.retrofitrecyclerview;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import java.util.TooManyListenersException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsViewModel extends ViewModel {
    MutableLiveData<List<Posts>> listMutableLiveData = new MutableLiveData<>();

    public void getPosts() {

        PostsClient.getINSTANCE().getAllPosts().enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                listMutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

            }
        });
    }

}
