package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.models.AbilityInfo;
import com.example.proyectofinalpokemon.viewmodel.AllTabViewModel;
import com.example.proyectofinalpokemon.viewmodel.DetailViewModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DetailFragment extends Fragment {

    private ImageView pokemonImageView;
    private TextView pokemonNameTextView;
    private TextView pokemonAbilitiesTextView;
    private DetailViewModel detailViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailViewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pokemonImageView = view.findViewById(R.id.pokemonImageView);
        pokemonNameTextView = view.findViewById(R.id.pokemonNameTextView);
        pokemonAbilitiesTextView = view.findViewById(R.id.pokemonAbilitiesTextView);

        pokemonNameTextView.setText(DetailFragmentArgs.fromBundle(getArguments()).getPokeName().toUpperCase());
        String pokemonId = DetailFragmentArgs.fromBundle(getArguments()).getPokeId();
        Picasso.get().load(DetailFragmentArgs.fromBundle(getArguments()).getPokeImg()).into(pokemonImageView);

        //Nueva llamada al Servidor para obtener las habilidades del Pokemon.
        detailViewModel.getAbilityListFromServer(pokemonId);
        detailViewModel.getAbilityList().observe(this.getViewLifecycleOwner(), new Observer<List<AbilityInfo>>() {
            @Override
            public void onChanged(List<AbilityInfo> abilityInfos) {
                String s = abilityInfos.get(0).getAbility().getAbilityName();
                String pokemonAbilities = "";

                for (int index = 0; index < abilityInfos.size(); index++){
                    pokemonAbilities = pokemonAbilities.concat(String.valueOf(index + 1)).concat(".  ").concat(abilityInfos.get(index).getAbility().getAbilityName()).concat("\n");
                }

                pokemonAbilitiesTextView.setText(pokemonAbilities);
            }
        });



    }
}
