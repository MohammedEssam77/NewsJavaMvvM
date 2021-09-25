package com.example.newsjavaMvvm.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.newsjavaMvvm.R;
import com.example.newsjavaMvvm.data.Constants;
import com.example.newsjavaMvvm.data.RecyclerClickListener;
import com.example.newsjavaMvvm.pojo.PostModel;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter <PostsAdapter.PostViewHolder> {
    private final Context context ;
    private List<PostModel>postNews;
    private final RecyclerClickListener recyclerClickListener ;

    public PostsAdapter (Context context , RecyclerClickListener recyclerClickListener ){
        this.context =context;
        this.recyclerClickListener=recyclerClickListener;
        postNews= new ArrayList<>();

    }
    public void setPostModel (List<PostModel>getNews) {
        this.postNews = getNews ;
        notifyDataSetChanged();

    }
    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_news,parent,false);
        return new PostViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostModel postModel = postNews .get(position);
        PostViewHolder postViewHolder = (PostViewHolder) holder ;
        postViewHolder.textTitle.setText(postModel.getTitle());
        postViewHolder.sourceTxt.setText(postModel.getSourceTitle());
        postViewHolder.btnTitle.setText(postModel.getSectionTitle());
        setImageHolder(postViewHolder.coverImg, postModel);
        Picasso.with(context)
                .load(Uri.parse(Constants.loadSourceImg(postModel.getSourceID())))
                .into(postViewHolder.sourceImg);

    }
    private void setImageHolder(ImageView image, PostModel postModel) {
        if (postModel.getRatio() == null || postModel.getRatio().equals("") ||
                postModel.getRatio().equals("1.55") || postModel.getRatio().equals("0")) {
            image.setVisibility(View.GONE);
        } else {
            WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            DisplayMetrics outMetrics = new DisplayMetrics();
            display.getMetrics(outMetrics);
            int width = outMetrics.widthPixels;
            int height = (int) (width / Double.parseDouble(postModel.getRatio()));
            image.setVisibility(View.VISIBLE);
            image.getLayoutParams().width = width;
            image.getLayoutParams().height = height;
            Picasso.with(context)
                    .load(Uri.parse(Constants.mediaURL + postModel.getImg()))
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(image);
        }
    }
    @Override
    public int getItemCount() {
        return postNews.size();
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {
        ImageView sourceImg , coverImg;
        TextView sourceTxt, textTitle, btnTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            sourceImg = itemView.findViewById(R.id.sourceImg);
            coverImg = itemView.findViewById(R.id.coverImage);
            sourceTxt = itemView.findViewById(R.id.sourceTxt);
            textTitle =itemView.findViewById(R.id.textTitle);
            btnTitle = itemView.findViewById(R.id.btnTitle);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (getAdapterPosition() != -1)
                        recyclerClickListener.recyclerViewClick(getAdapterPosition());
                }
            });

        }
    }
}
