package com.example.proyectofinalpokemon.models;

import com.google.gson.annotations.SerializedName;

public class Pokemon {
    private String pokemonImage;
    @SerializedName("name")
    private String pokemonName;
    private String pokemonDescription;
    private Boolean isFavorite;
    @SerializedName("url")
    private String pokemonUrl;
    private String pokemonId;

    public Pokemon(String pokemonImage, String pokemonName, String pokemonDescription, Boolean isFavorite, String pokemonUrl, String pokemonId) {
        this.pokemonImage = pokemonImage;
        this.pokemonName = pokemonName;
        this.pokemonDescription = pokemonDescription;
        this.isFavorite = isFavorite;
        this.pokemonUrl = pokemonUrl;
        this.pokemonId = pokemonId;
    }

    public String getPokemonImage() {
        return pokemonImage;
    }

    public void setPokemonImage(String pokemonImage) {
        this.pokemonImage = pokemonImage;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void getIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }


    public String getPokemonUrl() {
        return pokemonUrl;
    }

    public String getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(String pokemonId) {
        this.pokemonId = pokemonId;
    }
}
