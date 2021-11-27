package com.csto.inicioayudantia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usu,pas;
    Button botoncito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usu = (EditText) findViewById(R.id.usuario);
        pas = (EditText) findViewById(R.id.contra);
        botoncito = (Button) findViewById(R.id.sig);
        /**botoncito.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {

        //    }
        //}); texto comentado **/
    }

    public void IRamenu(View w)
    {
        String usuario=usu.getText().toString();
        String contraceña=pas.getText().toString();
        if (usuario.equals("admin"))
        {
            Intent I=new Intent(getApplicationContext(),Inicio.class);
            I.putExtra("S",usuario);
            startActivity(I);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Si no es admin no entra",Toast.LENGTH_LONG).show();

        }
    }
}