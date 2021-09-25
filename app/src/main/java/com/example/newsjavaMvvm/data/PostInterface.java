package com.example.newsjavaMvvm.data;

import com.example.newsjavaMvvm.pojo.PostModel;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface PostInterface {
    @Headers({
            "Content-type: application/json",
            "DeviceToken: 29A2506C-7C1C-40B9-8640-9ECA36659401",
            "AuthToken: dVMFDDAcZ1"
    })
    @GET("Api/News/GetNewsHome/209361/0/0/20/0")
    Call<List<PostModel>> getNews();

}
