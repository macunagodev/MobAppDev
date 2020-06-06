package com.example.proyectofinalpokemon.models;

import com.google.gson.annotations.SerializedName;

public class Ability {

    @SerializedName("name")
    private String abilityName;
    @SerializedName("url")
    private String abilityUrl;

    public Ability(String abilityName, String abilityUrl) {
        this.abilityName = abilityName;
        this.abilityUrl = abilityUrl;
    }

    public String getAbilityName() {
        return abilityName;
    }

    public String getAbilityUrl() {
        return abilityUrl;
    }
}
