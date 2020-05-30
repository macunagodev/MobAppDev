package com.example.proyectofinalpokemon.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    PokemonApiService pokemonApiService;

    public RetrofitProvider(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonApiService = retrofit.create(PokemonApiService.class);
    }

    public PokemonApiService getPokemonApiService() {
        return pokemonApiService;
    }
}
