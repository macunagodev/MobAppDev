package com.example.proyectofinalpokemon.api;

import com.example.proyectofinalpokemon.models.AbilityListResponse;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.models.PokemonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokemonApiService {
    @GET("pokemon")
    Call<PokemonListResponse> getPokemonList(@Query("offset") int offset, @Query("limit") int limit);

    @GET("pokemon/{id}")
    Call<AbilityListResponse> getAbilityList(@Path("id") String id);
}
