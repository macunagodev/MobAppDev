package com.example.fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import com.example.fragments.R;

public class PesoFragment extends Fragment {

    private Button calcularPesoButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_peso, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calcularPesoButton = view.findViewById(R.id.calcularPeso);
        calcularPesoButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                NavDirections action = PesoFragmentDirections.actionPesoFragmentToCalculoPesoFragment("Esta prueba esta funcionando");
                NavHostFragment.findNavController(PesoFragment.this).navigate(action);
            }
        });
    }
}
