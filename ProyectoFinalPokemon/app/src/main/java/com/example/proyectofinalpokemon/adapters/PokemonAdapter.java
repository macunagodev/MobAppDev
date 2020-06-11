package com.example.proyectofinalpokemon.adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.listener.OnPokemonClicked;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.viewmodel.DatabasePokemonViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder>{

    private List<Pokemon> pokemonList = new ArrayList<>();
    private OnPokemonClicked pokemonListener;

    public PokemonAdapter(OnPokemonClicked pokemonListener) {
        this.pokemonListener = pokemonListener;
    }

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
        holder.Bind(pokemonList.get(position), pokemonListener);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder{

        private String pokeId;
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

        public void Bind(final Pokemon pokemon, final OnPokemonClicked listener){
            if (pokemon.getPokemonId() == "" || pokemon.getPokemonId() == null){
                String[] pokeUrlParts = pokemon.getPokemonUrl().split("/");
                pokeId = pokeUrlParts[pokeUrlParts.length-1];
                pokemon.setPokemonId(pokeId);
            }

            pokemonNameTextView.setText(pokemon.getPokemonName());
            pokemonDescriptionTextView.setText(pokemon.getPokemonDescription());
            pokemon.setPokemonImage("https://pokeres.bastionbot.org/images/pokemon/" + pokemon.getPokemonId() + ".png");
            Picasso.get().load(pokemon.getPokemonImage()).into(pokemonNameImg);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClicked(pokemon);
                }
            });

            favoriteImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    //Drawable doriginal = favoriteImg.getDrawable();
                    //Drawable blackStar = Picasso.get().load(R.drawable.ic_star_black).into(favoriteImg);

                    if (favoriteImg.getDrawable() == ContextCompat.getDrawable(v.getContext(), R.drawable.ic_star_border_black)){
                        favoriteImg.setImageResource(R.drawable.ic_star_black);
                    } else {
                        favoriteImg.setImageResource(R.drawable.ic_star_border_black);
                    }

                    listener.onFavoriteClick(pokemon);
                }
            });
        }
    }
}
