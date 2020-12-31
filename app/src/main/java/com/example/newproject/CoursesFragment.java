package com.example.newproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class CoursesFragment extends Fragment implements Onclick {
    private ArrayList videoTitles = new ArrayList<String >(Arrays.asList("Java Tutorial for Beginners 1","Java Tutorial for Beginners 2","Java Tutorial for Beginners 3"
            ,"Java Tutorial for Beginners 4","Java Tutorial for Beginners 5","Java Tutorial for Beginners 6","Java Tutorial for Beginners 7"));
    private String urls[] = new String[]{  "r59xYe3Vyks","gzlhm0jco0g","gzlhm0jco0g","4ekASokneGU","qgMH6jOOFOE","ss7BtLrbxp4","f5YdkIzNmfM"};
    private YouTubePlayer youTubePlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_courses, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ArrayList arrayList = new ArrayList();
        RecyclerView recyclerView = view.findViewById(R.id.id_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        YoutubeVideoAdapter youtubeVideoAdapter = new YoutubeVideoAdapter(videoTitles,this);
        recyclerView.setAdapter(youtubeVideoAdapter);
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                String videoId = "r59xYe3Vyks";
                CoursesFragment.this.youTubePlayer = youTubePlayer;
                youTubePlayer.loadVideo(videoId,0f);
            }
        });

    }

    @Override
    public void onClick(int position) {
        if(youTubePlayer!=null)
        youTubePlayer.loadVideo(urls[position],0f);
    }
}
