package com.example.newsjavaMvvm.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newsjavaMvvm.data.PostsClient;
import com.example.newsjavaMvvm.pojo.PostModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {

    MutableLiveData <List<PostModel>> postsMutableLiveData =new MutableLiveData<>();
    MutableLiveData <String> posts = new MutableLiveData<>();

    public void getNews() {
        PostsClient.getINSTANCE().getNews().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(@NotNull Call<List<PostModel>> call, @NotNull Response<List<PostModel>> response) {
                postsMutableLiveData.setValue(response.body());

            }

            @Override
            public void onFailure(@NotNull Call<List<PostModel>> call, @NotNull Throwable t) {
                posts.setValue("errr");

            }
        });
    }
}

