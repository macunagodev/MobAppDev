package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectofinalpokemon.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class favoritesTabFragment extends Fragment {

    public favoritesTabFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites_tab, container, false);
    }
}
