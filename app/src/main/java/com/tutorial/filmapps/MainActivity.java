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
                getApplicationContext().getString(R.string.deskripsi3),R.drawable.deadpool1));

        filmModelList.add(new FilmModel("MORTAL KOMBAT","NEW LINE CINEMA ",
                getApplicationContext().getString(R.string.deskripsi4),R.drawable.mortalkombat));

        filmModelList.add(new FilmModel("SPIDERMAN : NO WAY HOME","MARVEL STUDIOS, COLOUMBIA PICTURES ",
                getApplicationContext().getString(R.string.deskripsi5),R.drawable.spiderman));

        filmModelList.add(new FilmModel("EXTRACTION"," AGBO, Thematic Entertainment",
                getApplicationContext().getString(R.string.deskripsi6),R.drawable.extraction));

        filmModelList.add(new FilmModel("PACIFIC RIM : UPRISING","LEGENDARY PICTURES",
                getApplicationContext().getString(R.string.deskripsi7),R.drawable.pacificrim));

        filmModelList.add(new FilmModel("REAL STEEL","DREAMWORK PICTURES",
                getApplicationContext().getString(R.string.deskripsi8),R.drawable.realsteel));

        filmModelList.add(new FilmModel("SUICIDE SQUAD","DC ENTERTAIMENT",
                getApplicationContext().getString(R.string.deskripsi9),R.drawable.suicidesquad));

        filmModelList.add(new FilmModel("WONDER WOMAN","DC FILMS",
                getApplicationContext().getString(R.string.deskripsi10),R.drawable.wonderwoman));


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