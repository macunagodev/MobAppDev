package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView calculoPesoTextView;
    private double total = 0;
    private double pesoTierra = 0;
    private String strTotal;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        calculoPesoTextView = (TextView) findViewById(R.id.calculateWeightTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pesoTierra = Double.valueOf(getIntent().getStringExtra("PESO")).doubleValue();
        total = (pesoTierra/9.81)*1.622;
        calculoPesoTextView.setText(getString(R.string.calculo_text, String.valueOf(total)));
        //calculoPesoTextView.setText("Ya Funciono");
    }

}
