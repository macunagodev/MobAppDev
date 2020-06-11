package com.example.proyectofinalpokemon.database.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.proyectofinalpokemon.database.PokemonRoomDatabase;
import com.example.proyectofinalpokemon.database.dao.PokemonDAO;
import com.example.proyectofinalpokemon.database.entity.PokemonDB;

import java.util.List;

public class PokemonRepository {
    private PokemonDAO pokemonDAO;

    public PokemonRepository(Context context){
        PokemonRoomDatabase db = PokemonRoomDatabase.getDatabase(context);
        pokemonDAO = db.pokemonDAO();
    }

    public void InsertPokemon(PokemonDB pokemon){
        if (pokemon != null && pokemonDAO != null){
            PokemonRoomDatabase.appDatabaseWriteExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    Boolean isFavorite = true;
                    PokemonDB pokemonDb = pokemonDAO.FindById(pokemon.getId());
                    if (pokemonDb != null){
                        isFavorite = pokemonDAO.FindById(pokemon.getId()).getIsFavorite();
                    }

                    pokemon.setIsFavorite(!isFavorite);
                    pokemonDAO.Insert(pokemon);
                }
            });
        }
    }

    public LiveData<PokemonDB> FindPokemonById(String pokeId){
        return pokemonDAO.FindById(pokeId);
    }

    public LiveData<List<PokemonDB>> GetAllFavoritePokemonList(){
        return pokemonDAO.getAllFavoritePokemonList();
    }

    public void DeletePokemon(String pokeId){
        pokemonDAO.Delete(pokeId);
    }
}
