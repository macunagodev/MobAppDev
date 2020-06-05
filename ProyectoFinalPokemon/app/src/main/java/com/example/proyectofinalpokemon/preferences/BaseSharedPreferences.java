package com.example.proyectofinalpokemon.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.proyectofinalpokemon.R;

public class BaseSharedPreferences {

    SharedPreferences sharedPref;

    public BaseSharedPreferences(Context context) {
        sharedPref = context.getSharedPreferences(context.getString(R.string.preference_file_key), Context.MODE_PRIVATE);
    }

    public void setTrainerName(String trainerName){
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(Constants.NAME_KEY, trainerName);
        editor.apply();
    }

    public String getTrainerName(){
        return sharedPref.getString(Constants.NAME_KEY, null);
    }
}
