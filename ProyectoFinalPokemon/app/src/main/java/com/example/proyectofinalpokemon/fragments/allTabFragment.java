package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.adapters.PokemonAdapter;
import com.example.proyectofinalpokemon.database.entity.PokemonDB;
import com.example.proyectofinalpokemon.listener.OnPokemonClicked;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.viewmodel.AllTabViewModel;
import com.example.proyectofinalpokemon.viewmodel.DatabasePokemonViewModel;

import java.util.ArrayList;
import java.util.List;

public class allTabFragment extends Fragment implements OnPokemonClicked {

    private RecyclerView recyclerView;
    private ImageView favoriteImg;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this);
    private AllTabViewModel viewModel;
    private DatabasePokemonViewModel dbViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AllTabViewModel.class);
        dbViewModel = new ViewModelProvider(this).get(DatabasePokemonViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_tab, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inflamos el recycle view para el pokemon.
        recyclerView = view.findViewById(R.id.pokemonAllRecyclerView);
        //favoriteImg = view.findViewById(R.id.imgFavorite);
        InitRecyclerView();
        viewModel.getPokemonListFromServer(); //Llamado al servidor.
        viewModel.getPokemonList().observe(this.getViewLifecycleOwner(), new Observer<List<Pokemon>>() { // Nos suscribimos al evento del get pokemon list.
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                pokemonAdapter.setPokemonList(pokemons);  //Aqui recibimos la respuesta del servidor.
            }
        }); // Para indicarle al viewmodel cual va a ser el ciclo de vida asociado.
    }

    private List<Pokemon> setIsFavorite(List<Pokemon> pokemonList){

        return pokemonList;
    }

    private void InitRecyclerView(){
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        //fillMockData();
        //getPokemonList();
    }

    // Metodo que simula llamada al servidor.
    private void fillMockData(){
        List<Pokemon> pokemonList = new ArrayList<>();
        Pokemon pokemon = new Pokemon("", "Pikachu", "Pokemon del Rayo", true, "", "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Metapod", "Pokemon capullo", true, "", "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Sharmander", "Pokemon de Fuego", false, "", "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Giglipop", "Pokemon globo", true, "", "");
        pokemonList.add(pokemon);

        pokemonAdapter.setPokemonList(pokemonList);
    }

    @Override
    public void onClicked(Pokemon pokemon) {
        Log.d("Item clicked: ", pokemon.getPokemonName());
        NavDirections action = MenuFragmentDirections.actionMenuFragmentToDetailFragment(pokemon.getPokemonId(), pokemon.getPokemonImage(), pokemon.getPokemonName());
        NavHostFragment.findNavController(allTabFragment.this).navigate(action);
    }

    @Override
    public void onFavoriteClick(Pokemon pokemon) {
        //Logica de guardar a base de datos.
        Log.d("Favorite pokemon", "Favorite");
        dbViewModel.InsertPokemon(pokemon.getPokemonId(), pokemon.getPokemonName(), pokemon.getPokemonImage(), true);
    }
}
