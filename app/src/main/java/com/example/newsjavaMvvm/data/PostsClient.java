package com.example.newsjavaMvvm.data;

import com.example.newsjavaMvvm.pojo.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private static final String base_url = "http://apiversion10.thezagelapp.com/";
    private static PostsClient INSTANCE;
    private PostInterface postInterface;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }
    public Call<List<PostModel>> getNews(){
        return postInterface.getNews();
    }
}
