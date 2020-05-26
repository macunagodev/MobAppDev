package com.example.proyectofinalpokemon.models;

public class Pokemon {
    private String pokemonImage;
    private String pokemonName;
    private String pokemonDescription;
    private Boolean isFavorite;

    public Pokemon(String pokemonImage, String pokemonName, String pokemonDescription, Boolean isFavorite) {
        this.pokemonImage = pokemonImage;
        this.pokemonName = pokemonName;
        this.pokemonDescription = pokemonDescription;
        this.isFavorite = isFavorite;
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
}
