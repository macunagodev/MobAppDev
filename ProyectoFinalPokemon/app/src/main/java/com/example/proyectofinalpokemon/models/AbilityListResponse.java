package com.example.proyectofinalpokemon.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AbilityListResponse {

    @SerializedName("abilities")
    private
    List<AbilityInfo> abilityInfoList;


    public List<AbilityInfo> getAbilityInfoList() {
        return abilityInfoList;
    }

    public void setAbilityInfoList(List<AbilityInfo> abilityInfoList) {
        this.abilityInfoList = abilityInfoList;
    }
}
