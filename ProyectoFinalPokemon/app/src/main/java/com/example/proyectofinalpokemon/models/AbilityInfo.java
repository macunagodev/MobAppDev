package com.example.proyectofinalpokemon.models;

import com.google.gson.annotations.SerializedName;

public class AbilityInfo {

    @SerializedName("ability")
    private Ability ability;
    @SerializedName("is_hidden")
    private Boolean isHidden;
    @SerializedName("slot")
    private int slot;

    public AbilityInfo(Ability ability, Boolean isHidden, int slot) {
        this.setAbilityList(ability);
        this.setHidden(isHidden);
        this.setSlot(slot);
    }

    public Ability getAbility() {
        return ability;
    }

    public void setAbilityList(Ability ability) {
        this.ability = ability;
    }

    public Boolean getHidden() {
        return isHidden;
    }

    public void setHidden(Boolean hidden) {
        isHidden = hidden;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }
}
