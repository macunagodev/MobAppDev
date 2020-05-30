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

    public Pokemon(String pokemonImage, String pokemonName, String pokemonDescription, Boolean isFavorite, String pokemonUrl) {
        this.pokemonImage = pokemonImage;
        this.pokemonName = pokemonName;
        this.pokemonDescription = pokemonDescription;
        this.isFavorite = isFavorite;
        this.pokemonUrl = pokemonUrl;
    }

    public String getPokemonImage() {
        return pokemonImage;
    }

    public String getPokemonName() {
        return pokemonName;
    }

    public String getPokemonDescription() {
        return pokemonDescription;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public String getPokemonUrl() {
        return pokemonUrl;
    }
}
