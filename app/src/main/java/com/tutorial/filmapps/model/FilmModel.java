package com.tutorial.filmapps.model;

public class FilmModel {
    String judul ;
    String deskripsi;
    String deskripsi_lengkap;
    int photo;

    public FilmModel(String judul, String deskripsi, String deskripsi_lengkap, int photo) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.deskripsi_lengkap = deskripsi_lengkap;
        this.photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getDeskripsi_lengkap() {
        return deskripsi_lengkap;
    }

    public int getPhoto() {
        return photo;
    }
}
