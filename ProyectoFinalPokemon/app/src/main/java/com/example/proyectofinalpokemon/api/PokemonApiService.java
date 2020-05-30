package com.example.proyectofinalpokemon.api;

import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.models.PokemonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApiService {
    @GET("pokemon")
    Call<PokemonListResponse> getPokemonList();
    //Call<List<Pokemon>> getPokemonList(@Query("sol") int sol, @Query("api_key") String apikey);
}
