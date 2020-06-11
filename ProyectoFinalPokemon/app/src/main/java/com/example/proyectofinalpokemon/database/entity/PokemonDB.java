package com.example.proyectofinalpokemon.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "pokemon")
public class PokemonDB {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "pokemon_id")
    private String id;
    @ColumnInfo(name = "pokemon_name")
    private String name;
    @ColumnInfo(name = "pokemon_image")
    private String image;
    @ColumnInfo(name = "is_favorite")
    private Boolean isFavorite;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean favorite) {
        isFavorite = favorite;
    }

    public PokemonDB(String id, String name, String image, Boolean isFavorite){
        this.id = id;
        this.name = name;
        this.image = image;
        this.isFavorite = isFavorite;
    }
}
