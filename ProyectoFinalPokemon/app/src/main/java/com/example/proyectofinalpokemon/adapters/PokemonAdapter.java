package com.example.proyectofinalpokemon.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.models.Pokemon;
import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>{

    private List<Pokemon> pokemonList = new ArrayList<>();

    public void setPokemonList(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_recycler_view, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        holder.Bind(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder{

        private ImageView pokemonNameImg;
        private ImageView favoriteImg;
        private TextView pokemonNameTextView;
        private TextView pokemonDescriptionTextView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);

            pokemonNameImg = itemView.findViewById(R.id.imgPokemon);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
            pokemonDescriptionTextView = itemView.findViewById(R.id.pokemonDescriptionTextView);
            favoriteImg = itemView.findViewById(R.id.imgFavorite);
        }

        public void Bind(Pokemon pokemon){
            pokemonNameTextView.setText(pokemon.getPokemonName());
            pokemonDescriptionTextView.setText(pokemon.getPokemonDescription());
        }
    }
}