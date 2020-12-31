package com.example.newproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YoutubeVideoViewHolder> {
    private ArrayList<String> videoTitles;
    private Onclick onclick;
    public YoutubeVideoAdapter(ArrayList<String> videoTitles,Onclick onclick){
        this.videoTitles = videoTitles;
        this.onclick=onclick;
    }
    @NonNull
    @Override
    public YoutubeVideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new YoutubeVideoViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_youtube_video,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeVideoViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return videoTitles.size();
    }

    class YoutubeVideoViewHolder extends RecyclerView.ViewHolder{
    TextView videoTitle;
    public YoutubeVideoViewHolder(@NonNull final View itemView) {
        super(itemView);
        videoTitle = itemView.findViewById(R.id.id_video_title);
        videoTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclick.onClick(getAdapterPosition());
            }
        });
    }

        public void bind(int position) {
        if(position==0 || position==5){
            TextView videoHeading = itemView.findViewById(R.id.id_video_heading);
            videoHeading.setVisibility(View.VISIBLE);
        if(position==0){
            videoHeading.setText("Begginer Module");
        }else {
            videoHeading.setText("Intermediate Module");
        }
        }
        videoTitle.setText(videoTitles.get(position));
        }
    }
}
