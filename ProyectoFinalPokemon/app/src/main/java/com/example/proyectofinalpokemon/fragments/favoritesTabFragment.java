package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.adapters.PokemonAdapter;
import com.example.proyectofinalpokemon.database.entity.PokemonDB;
import com.example.proyectofinalpokemon.listener.OnPokemonClicked;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.viewmodel.DatabasePokemonViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class favoritesTabFragment extends Fragment implements OnPokemonClicked {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this);
    private DatabasePokemonViewModel dbViewModel;

    private List<Pokemon> ConvertToPokemonList(List<PokemonDB> pokemonDbList){
        List<Pokemon> newPokemonList = new ArrayList<>();

        if (pokemonDbList != null && pokemonDbList.size() > 0){
            for (int index = 0; index < pokemonDbList.size(); index++){
                newPokemonList.add(new Pokemon(
                        pokemonDbList.get(index).getImage(),
                        pokemonDbList.get(index).getName(),
                        "",
                        pokemonDbList.get(index).getIsFavorite(),
                        "",
                        pokemonDbList.get(index).getId()));
            }
        }

        return newPokemonList;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dbViewModel = new ViewModelProvider(this).get(DatabasePokemonViewModel.class);
    }

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

        //Leer de la base de datos los pokemones favoritos
        dbViewModel.GetAllFavoritePokemonList().observe(getViewLifecycleOwner(), new Observer<List<PokemonDB>>() {
            @Override
            public void onChanged(List<PokemonDB> pokemonDBS) {
                int count = pokemonDBS.size();
                pokemonAdapter.setPokemonList(ConvertToPokemonList(pokemonDBS));
            }
        });
        //List<Pokemon> p = ConvertToPokemonList(favoritePokemonList);
        //pokemonAdapter.setPokemonList(p);
    }

    private void InitRecyclerView(){
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        //fillMockData();
    }

    // Metodo que simula llamada al servidor.
    private void fillMockData(){
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pokemon = new Pokemon("", "Pikachu", "Pokemon del Rayo", true, "", "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Sharmander", "Pokemon de Fuego", false, "", "");
        pokemonList.add(pokemon);

        pokemonAdapter.setPokemonList(pokemonList);
    }

    @Override
    public void onClicked(Pokemon pokemon) {
        Log.d("Item clicked: ", pokemon.getPokemonName());
        NavDirections action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(pokemon.getPokemonId(), pokemon.getPokemonImage(), pokemon.getPokemonName());
        NavHostFragment.findNavController(favoritesTabFragment.this).navigate(action);
    }

    @Override
    public void onFavoriteClick(Pokemon pokemon) {

    }
}
