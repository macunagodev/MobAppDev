package com.example.proyectofinalpokemon.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.proyectofinalpokemon.api.RetrofitProvider;
import com.example.proyectofinalpokemon.models.AbilityInfo;
import com.example.proyectofinalpokemon.models.AbilityListResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailViewModel extends ViewModel {
    private MutableLiveData<List<AbilityInfo>> abilityList = new MutableLiveData<>();

    public LiveData<List<AbilityInfo>> getAbilityList() {
        return abilityList;
    }

    public void getAbilityListFromServer(String id){
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getAbilityList(id).enqueue(new Callback<AbilityListResponse>() {
            @Override
            public void onResponse(Call<AbilityListResponse> call, Response<AbilityListResponse> response) {
                if (response.isSuccessful()){
                    Log.e("SUCCESSFUL RESPONSE", "Success.");
                    //Log.d("Pokemon List", response.body().getPokemonList().get(0).getPokemonName());
                    abilityList.postValue(response.body().getAbilityInfoList());
                }else {
                    Log.e("SERVER ERROR", "Error.");
                }
            }

            @Override
            public void onFailure(Call<AbilityListResponse> call, Throwable error) {
                Log.e("SERVER ERROR", error.getLocalizedMessage());
            }
        });
    }
}
