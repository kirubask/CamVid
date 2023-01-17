package com.example.camvid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button camera;
    Button video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera = findViewById(R.id.camera);
        video = findViewById(R.id.Video);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               replaceFragment(new Camera());
               camera.setVisibility(view.GONE);
               video.setVisibility(view.GONE);
            }
        });

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new VideoFragment());
                camera.setVisibility(view.GONE);
                video.setVisibility(view.GONE);

            }
        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.franeLayout,fragment);
        fragmentTransaction.commit();
    }


}