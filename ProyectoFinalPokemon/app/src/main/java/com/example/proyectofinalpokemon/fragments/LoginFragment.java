package com.example.proyectofinalpokemon.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHostController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.proyectofinalpokemon.R;
import com.example.proyectofinalpokemon.preferences.BaseSharedPreferences;
import com.google.android.material.textfield.TextInputEditText;

public class LoginFragment extends Fragment {

    private Button submitButton;
    private TextInputEditText trainerTextInputEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        BaseSharedPreferences baseSharedPreferences = new BaseSharedPreferences(requireContext());
        String trainerName;
        submitButton = view.findViewById(R.id.btnSubmit);
        trainerTextInputEditText = view.findViewById(R.id.trainerNameTextInputEditText);
        trainerName = baseSharedPreferences.getTrainerName();

        if(trainerName != null){
            trainerTextInputEditText.setText(trainerName);
        } else {
            trainerTextInputEditText.setText("");
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseSharedPreferences.setTrainerName(trainerTextInputEditText.getText().toString());
                //NavHostFragment.findNavController(LoginFragment.this).navigate(R.id.action_loginFragment_to_menuFragment);
                NavDirections action = LoginFragmentDirections.actionLoginFragmentToMenuFragment("Mauricio");
                NavHostFragment.findNavController(LoginFragment.this).navigate(action);
            }
        });

    }
}
