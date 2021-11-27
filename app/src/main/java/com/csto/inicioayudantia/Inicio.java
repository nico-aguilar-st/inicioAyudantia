package com.csto.inicioayudantia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Inicio extends AppCompatActivity {
    Spinner listt;
    Button map;
    ArrayList Lugares;
    RadioButton vincu;
    Float efe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        listt = (Spinner) findViewById(R.id.spn_lista);
        map = (Button) findViewById(R.id.btn_maps);
        vincu = (RadioButton) findViewById(R.id.RB);

        ArrayList <String> Lugares = new ArrayList<>();
        Lugares.add("Lugar 1");
        Lugares.add("Lugar 2");
        Lugares.add("Lugar 3");
        ArrayAdapter adaptador = new ArrayAdapter<String>(getApplicationContext(),R.layout.support_simple_spinner_dropdown_item,Lugares);
        listt.setAdapter(adaptador);

        Bundle b = getIntent().getExtras();
        String usar = b.getString("S");
        Toast.makeText(getApplicationContext(),"Bienvenido: "+usar,Toast.LENGTH_LONG).show();

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(getApplicationContext(),Mapita.class);
                I.putExtra("Lug",listt.getSelectedItem().toString());
                //I.putExtra("S",usar);
                if (vincu.isChecked())
                {
                    efe=(float) 15;
                }
                else
                {
                    efe=(float) 0;
                }
                I.putExtra("zoom",efe);
                startActivity(I);
            }
        });

    }
}