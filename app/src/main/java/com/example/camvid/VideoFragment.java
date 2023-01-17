package com.example.camvid;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.VideoView;

public class VideoFragment extends Fragment {
    View view;
    Button videoBtn;
    Button galleryVideo;
    VideoView videoView;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        videoBtn =  view.findViewById(R.id.VideoBtn);
        galleryVideo = view.findViewById(R.id.gallery);
        videoView = view.findViewById(R.id.Video);
        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video, container, false);
        return  view;
    }
}