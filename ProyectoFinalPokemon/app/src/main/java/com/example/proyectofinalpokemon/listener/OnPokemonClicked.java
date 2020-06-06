package com.example.proyectofinalpokemon.listener;

import com.example.proyectofinalpokemon.models.Pokemon;

public interface OnPokemonClicked {
    void onClicked(Pokemon pokemon);
    void onFavoriteClick(Pokemon pokemon);
}
