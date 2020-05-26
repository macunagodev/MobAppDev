package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.adapters.PokemonAdapter;
import com.example.proyectofinalpokemon.models.Pokemon;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class favoritesTabFragment extends Fragment {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inflamos el recycle view para el pokemon.
        recyclerView = view.findViewById(R.id.pokemonRecyclerView);
        InitRecyclerView();
    }

    private void InitRecyclerView(){
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        fillMockData();
    }

    // Metodo que simula llamada al servidor.
    private void fillMockData(){
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pokemon = new Pokemon("", "Pikachu", "Pokemon del Rayo", true);
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Pikachu", "Pokemon del Rayo", true);
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Sharmander", "Pokemon de Fuego", false);
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Giglipop", "Pokemon globo", true);
        pokemonList.add(pokemon);

        pokemonAdapter.setPokemonList(pokemonList);
    }
}