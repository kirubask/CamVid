package com.example.camvid;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.File;

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
        videoView = view.findViewById(R.id.videoView);

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                captureVideo.launch(intent);
            }
        });


        galleryVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pick = new Intent(Intent.ACTION_PICK,MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
                pickVideo.launch(pick);
            }
        });

        }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video, container, false);

        return  view;
    }

    ActivityResultLauncher<Intent> captureVideo = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null ){
//            result   = result.getData().getExtras();
////            Bitmap bitmap = (Bitmap) bundle.get("data");
////            videoView.setVideoURI();
            Uri uri = result.getData().getData();
            videoView.setVideoURI(uri);
            MediaController mediaController = new MediaController(getContext());
            videoView.setMediaController(mediaController);
//            videoView.start();
        }
            });


    ActivityResultLauncher<Intent> pickVideo = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null){
            Uri uri = result.getData().getData();
            videoView.setVideoURI(uri);

        }
            });
}