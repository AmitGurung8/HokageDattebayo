package org.example.hokagedattebayo.Models;

import java.util.ArrayList;
import java.util.SequencedCollection;

public class Character {
    public String name;
    public Debut debut;
    public ArrayList<String> jutsu;
    public ArrayList<String> images;

    public ArrayList<String> getImages() {
        return images;
    }

    public void setImages(ArrayList<String> image) {
        this.images = image;
    }

    public ArrayList<String> getJutsu() {
        return jutsu;
    }

    public void setJutsu(ArrayList<String> jutsu) {
        this.jutsu = jutsu;
    }



    public Debut getDebut() {
        return debut;
    }

    public void setDebut(Debut debut) {
        this.debut = debut;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
