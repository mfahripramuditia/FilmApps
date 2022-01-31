package com.tutorial.filmapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
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
        setTitle("Film Apps");

        filmModelList = new ArrayList<>();
        filmAdapter = new FilmAdapter(MainActivity.this, filmModelList  );
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(filmAdapter);

        filmModelList.add(new FilmModel("KEP. KARIMUNJAWA","KAB. JEPARA, JAWA TENGAH",
                getApplicationContext().getString(R.string.deskripsi1), R.drawable.karimunjawa));



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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        MenuItem profil = menu.findItem(R.id.profil);
        profil.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(intent);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}