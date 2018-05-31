package com.example.als.combustivel;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnCalculo;
    EditText etAlcool, etGasolina;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAlcool = findViewById(R.id.editTextAlcool);
        etGasolina = findViewById(R.id.editTextGasolina);
        tvResultado = findViewById(R.id.textViewResultado);
        btnCalculo = findViewById(R.id.buttonCalculo);

        btnCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvResultado.setText("");
                if (etAlcool.getText().length()!=0 && etGasolina.getText().length()!=0){
                    double valor1 = Double.parseDouble(etAlcool.getText().toString());
                    double valor2 = Double.parseDouble(etGasolina.getText().toString());
                    double res = valor1/valor2;
                    if (res>0.7){
                        tvResultado.setText("Abasteça com Gasolina");
                    }
                    else if (res<0.7){
                        tvResultado.setText("Abasteça com Alcool");
                    }
                    else {
                        tvResultado.setText("Abasteça com Cachaça");
                    }
                }
                else {
                    Context contex = getApplicationContext();
                    int tempo = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(contex, "Preenchimento dos campos obrigatórios", tempo);
                    toast.show();
                }
            }
        });
    }
}