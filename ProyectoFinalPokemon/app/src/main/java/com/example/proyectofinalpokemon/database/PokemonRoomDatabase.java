package com.example.proyectofinalpokemon.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyectofinalpokemon.database.dao.PokemonDAO;
import com.example.proyectofinalpokemon.database.entity.PokemonDB;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {PokemonDB.class}, version = 1, exportSchema = false)
public abstract class PokemonRoomDatabase extends RoomDatabase {

    public abstract PokemonDAO pokemonDAO();

    private static volatile PokemonRoomDatabase INSTANCE;
    public static final ExecutorService appDatabaseWriteExecutor = Executors.newFixedThreadPool(4); // 4 es lo recomendado en CodeLab

    public static PokemonRoomDatabase getDatabase(Context context){
        if (INSTANCE == null){
            synchronized (PokemonRoomDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context, PokemonRoomDatabase.class, "pokemon_database").build();
                }
            }
        }

        return INSTANCE;
    }
}
