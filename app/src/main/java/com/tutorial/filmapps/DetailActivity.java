package com.tutorial.filmapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {

    ImageView img_photo;
    TextView judul, deskripsi_lengkap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();


        img_photo = (ImageView) findViewById(R.id.img_photo);
        judul = (TextView) findViewById(R.id.judul);
        deskripsi_lengkap = (TextView) findViewById(R.id.deskripsi_lengkap);

        judul.setText(intent.getStringExtra("judul"));

        deskripsi_lengkap.setText(intent.getStringExtra("deskripsi_lengkap"));

//        Glide.with(DetailActivity.this).load(intent.getStringExtra("photo")).apply(new RequestOptions().override(350,550))
//                .into(img_photo);

        Glide.with(DetailActivity.this)
                .load(intent.getIntExtra("photo",0))
                .into(img_photo);
    }
}
