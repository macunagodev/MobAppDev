package com.example.proyectofinalpokemon.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.proyectofinalpokemon.database.entity.PokemonDB;
import com.example.proyectofinalpokemon.models.Pokemon;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Dao
public interface PokemonDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void Insert(PokemonDB pokemon);

    @Query("Select * From pokemon Where pokemon_id = :pokeId")
    PokemonDB FindById(String pokeId);

    @Query("Select * From pokemon Where is_favorite = 1")
    LiveData<List<PokemonDB>> getAllFavoritePokemonList();

    //@Update("Update pokemon Set is_favorite = :favorite Where pokemon_id = :pokeid")
    @Update
    void Update(PokemonDB pokemon);

    @Query("Delete From pokemon Where pokemon_id = :pokeId ")
    void Delete(String pokeId);

    /*
    @Delete
    void Delete();

    @Update
    void Update();*?/

    @Query()
    void Query();
    */
}
