package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.adapters.PokemonAdapter;
import com.example.proyectofinalpokemon.api.RetrofitProvider;
import com.example.proyectofinalpokemon.listener.OnPokemonClicked;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.models.PokemonListResponse;
import com.example.proyectofinalpokemon.viewmodel.AllTabViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class allTabFragment extends Fragment implements OnPokemonClicked {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this);
    private AllTabViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AllTabViewModel.class);
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
        InitRecyclerView();
        viewModel.getPokemonListFromServer(); //Llamado al servidor.
        viewModel.getPokemonList().observe(this.getViewLifecycleOwner(), new Observer<List<Pokemon>>() { // Nos suscribmos al evento del get pokemon list.
            @Override
            public void onChanged(List<Pokemon> pokemons) {
                pokemonAdapter.setPokemonList(pokemons);  //Aqui recibimos la respuesta del servidor.
            }
        }); // Para indicarle al viewmodel cual va a ser el ciclo de vida asociado.
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
        Pokemon pokemon = new Pokemon("", "Pikachu", "Pokemon del Rayo", true, "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Metapod", "Pokemon capullo", true, "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Sharmander", "Pokemon de Fuego", false, "");
        pokemonList.add(pokemon);

        pokemon = new Pokemon("", "Giglipop", "Pokemon globo", true, "");
        pokemonList.add(pokemon);

        pokemonAdapter.setPokemonList(pokemonList);
    }

    @Override
    public void onClicked(Pokemon pokemon) {
        Log.d("Item clicked: ", pokemon.getPokemonName());
    }
}
