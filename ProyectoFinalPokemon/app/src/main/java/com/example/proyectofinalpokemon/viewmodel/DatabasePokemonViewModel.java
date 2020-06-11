package com.example.proyectofinalpokemon.viewmodel;

import android.app.Application;
import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.Transformations;

import com.example.proyectofinalpokemon.database.entity.PokemonDB;
import com.example.proyectofinalpokemon.database.repository.PokemonRepository;

import java.util.ArrayList;
import java.util.List;

public class DatabasePokemonViewModel extends AndroidViewModel {

    private static final String QUERY_KEY = "QUERY";
    private PokemonRepository repository;

    public DatabasePokemonViewModel(@NonNull Application application) {
        super(application);
        repository = new PokemonRepository(application.getApplicationContext());
    }

    public void InsertPokemon(String id, String name, String image, Boolean isFavorite){
        repository.InsertPokemon(new PokemonDB(id, name, image, isFavorite));
    }
/*
    public LiveData<PokemonDB> FindPokemonById (String pokeId)
    {
        return repository.FindPokemonById(pokeId);
    }*/

    public LiveData<List<PokemonDB>> GetAllFavoritePokemonList(){
        return repository.GetAllFavoritePokemonList();
    }

    public void DeletePokemon(String pokeId){
        repository.DeletePokemon(pokeId);
    }
}
