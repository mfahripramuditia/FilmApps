package com.tutorial.filmapps.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tutorial.filmapps.DetailActivity;
import com.tutorial.filmapps.MainActivity;
import com.tutorial.filmapps.R;
import com.tutorial.filmapps.model.FilmModel;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {
    Context context;
    List<FilmModel> filmModelList ;

    public FilmAdapter(Context context, List<FilmModel> filmModelList) {
        this.context = context;
        this.filmModelList = filmModelList;
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film,parent,false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {

        holder.judul.setText(filmModelList.get(position).getJudul());
        holder.deskripsi.setText(filmModelList.get(position).getDeskripsi());
        holder.cardFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("judul", filmModelList.get(position).getJudul());
                intent.putExtra("deskripsi", filmModelList.get(position).getDeskripsi());
                intent.putExtra("deskripsi_lengkap", filmModelList.get(position).getDeskripsi_lengkap());
                intent.putExtra("photo", filmModelList.get(position).getPhoto());
                ((MainActivity) context).startActivity(intent);


            }
        });
        Glide.with(holder.itemView)
                .load(filmModelList.get(position).getPhoto()).apply(new RequestOptions().override(55,55))
                .into(holder.photo);
    }

    @Override
    public int getItemCount() {
        return filmModelList.size();
    }

    class FilmHolder extends RecyclerView.ViewHolder {
        CardView cardFilm;
        TextView judul,deskripsi;
        ImageView photo;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);

            judul = (TextView) itemView.findViewById(R.id.judul);
            deskripsi = (TextView) itemView.findViewById(R.id.deskripsi);
            cardFilm = (CardView) itemView.findViewById(R.id.card_film);
            photo = (ImageView) itemView.findViewById(R.id.logofilm);


        }
    }
}
