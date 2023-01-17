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


public class Camera extends Fragment {

    Button camera;
    Button gallery;
    ImageView imageView;
    View view;
    private static final int pic_id = 123;



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        camera = view.findViewById(R.id.camera);
        gallery = view.findViewById(R.id.galleryImage);
        imageView = view.findViewById(R.id.imageView);
        camera.setOnClickListener(v -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            activityResultLauncher.launch(intent);

        });

        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gal = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                takeImage.launch(gal);
            }
        });


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view = inflater.inflate(R.layout.fragment_camera, container, false);
        return  view;
    }

    ActivityResultLauncher<Intent>  activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() !=  null){
            Bundle bundle  = result.getData().getExtras();
            Bitmap bitmap = (Bitmap) bundle.get("data");
            imageView.setImageBitmap(bitmap);
        }

            });

    ActivityResultLauncher<Intent> takeImage = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            result -> {
        if (result.getResultCode() == RESULT_OK && result.getData() != null){
            Uri uri = result.getData().getData();
            imageView.setImageURI(uri);

        }
            });
}