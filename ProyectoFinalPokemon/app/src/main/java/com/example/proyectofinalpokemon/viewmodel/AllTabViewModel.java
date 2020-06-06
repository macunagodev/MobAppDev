package com.example.proyectofinalpokemon.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectofinalpokemon.api.RetrofitProvider;
import com.example.proyectofinalpokemon.models.Pokemon;
import com.example.proyectofinalpokemon.models.PokemonListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllTabViewModel extends ViewModel {

    private MutableLiveData<List<Pokemon>> pokemonList = new MutableLiveData<>();
    // string MutableLiveData errorMessage;

    public LiveData<List<Pokemon>> getPokemonList() {
        return pokemonList;
    }

    public void getPokemonListFromServer(){
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getPokemonList(20, 1000).enqueue(new Callback<PokemonListResponse>() {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                if (response.isSuccessful()){
                    Log.d("Pokemon List", response.body().getPokemonList().get(0).getPokemonName());
                    //pokemonAdapter.setPokemonList(response.body().getPokemonList());
                    pokemonList.postValue(response.body().getPokemonList()); // Estamos publicando un valor con la lista de pokemones
                } else {
                    Log.e("SERVER ERROR", "Error.");
                    // pokemonError.postValue("Ha ocurrido un error");
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable error) {
                Log.e("SERVER ERROR", error.getLocalizedMessage());
            }
        });
    }
}
