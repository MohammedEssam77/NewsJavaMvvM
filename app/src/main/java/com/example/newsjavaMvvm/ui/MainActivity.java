package com.example.newsjavaMvvm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.Observer;

import android.os.Bundle;

import com.example.newsjavaMvvm.R;
import com.example.newsjavaMvvm.adapters.PostsAdapter;
import com.example.newsjavaMvvm.data.RecyclerClickListener;
import com.example.newsjavaMvvm.pojo.PostModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerClickListener {
    PostViewModel postViewModel ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getNews();
        RecyclerView recyclerView = findViewById(R.id.recNews);
        final PostsAdapter postsAdapter = new PostsAdapter(this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postsAdapter);

        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postsAdapter.setPostModel(postModels);
            }
        });


    }

    @Override
    public void recyclerViewClick(int Position) {

    }

}