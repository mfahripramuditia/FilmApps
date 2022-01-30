package com.tutorial.filmapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.tutorial.filmapps.adapter.FilmAdapter;
import com.tutorial.filmapps.model.FilmModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<FilmModel> filmModelList;
    FilmAdapter filmAdapter;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Film Apps");

        filmModelList = new ArrayList<>();
        filmAdapter = new FilmAdapter(MainActivity.this, filmModelList  );
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(filmAdapter);

        filmModelList.add(new FilmModel("ETERNALS","MARVEL STUDIOS",
                getApplicationContext().getString(R.string.deskripsi1), R.drawable.eternals));

        filmModelList.add(new FilmModel("JUMANJI","20th CENTURY FOX ",
                getApplicationContext().getString(R.string.deskripsi2),R.drawable.jumanji));

        filmModelList.add(new FilmModel("DEADPOOL","20th CENTURY FOX ",
                getApplicationContext().getString(R.string.deskripsi3),R.drawable.deadpool2));

        filmModelList.add(new FilmModel("MORTAL KOMBAT","NEW LINE CINEMA ",
                getApplicationContext().getString(R.string.deskripsi3),R.drawable.deadpool2));

        filmAdapter.notifyDataSetChanged();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemid = item.getItemId();
        if (itemid == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}