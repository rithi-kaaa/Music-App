package com.example.musicplayer;

import androidx.annotation.NonNull;


public class Song {

    private String id;
    private String title;
    private String artiste;
    private String fileLink;
    private double songLength;
    private int drawable;

    public Song(String id,String title, String artiste, String fileLink, double songLength, int drawable){
        //initialise the object
        this.id = id;
        this.title = title;
        this.artiste = artiste;
        this.fileLink = fileLink;
        this.songLength = songLength;
        this.drawable = drawable;
    }
    //Getters

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getArtiste() { return artiste; }
    public String getFileLink() { return fileLink; }
    public double getSongLength() { return songLength; }
    public int getDrawable() { return drawable; }

    //Setters
    public void setId(String Id){ this.id = id; }
    public void setTitle(String Title){this.title = title; }
    public void setArtiste(String Artiste){this.artiste = artiste; }
    public void setFileLink(String FileLink){this.fileLink = fileLink; }
    public void setSongLength(double SongLength){this.songLength = songLength; }
    public void setDrawable(int Drawable){this.drawable = drawable; }

}
