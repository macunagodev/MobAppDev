package com.example.fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.example.fragments.R;

public class CalculoPesoFragment extends Fragment {

    private TextView resultadoTextView;
    private double total = 0;
    private double pesoTierra = 0;
    private String strPesoTierra;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_calculopeso, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        resultadoTextView = view.findViewById(R.id.calculateWeightTextView);
        //strPesoTierra = CalculoPesoFragmentArgs.fromBundle(getArguments()).getPesoTierra();
        //pesoTierra = Double.parseDouble(CalculoPesoFragmentArgs.fromBundle(getArguments()).getPesoTierra());

        //pesoTierra = Double.parseDouble(CalculoPesoFragmentArgs.fromBundle(getArguments()).getPesoTierra());
        //total = (pesoTierra/9.81)*1.622;
        //resultadoTextView.setText(getString(R.string.calculo_text, String.valueOf(total)));
        //resultadoTextView.setText(CalculoPesoFragmentArgs.fromBundle(getArguments()).getPesoTierra());
    }
}
