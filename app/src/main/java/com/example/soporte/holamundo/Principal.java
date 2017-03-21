package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Declaración de variables
    private EditText cajaNombre;
    private EditText cajaSegundoNomb;
    private EditText cajaPrimerApell;
    private EditText cajaSegundoApell;
    private EditText cajaEdad;
    private EditText cajaSexo;
    private Intent i; //Objeto que permite pasar de una actividad a otra.
    private Bundle b; //Objeto para capsular los datos- para pasar la información de una actividad a otra.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        //Capturar cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaSegundoNomb =(EditText)findViewById(R.id.txtSegundoNomb);
        cajaPrimerApell = (EditText)findViewById(R.id.txtPrimerApell);
        cajaSegundoApell = (EditText)findViewById(R.id.txtSegundoApell);
        cajaEdad = (EditText)findViewById(R.id.txtEdad);
        cajaSexo = (EditText)findViewById(R.id.txtSexo);

        //Crear Intent
        i= new Intent(this,Saludo.class);

        //Crear capsula
        b = new Bundle();
    }


    public void mostrar(View v){

        String nomb, segundoNomb, apell, segundoApell, edad, sexo;



        //Capturar valores de las cajas
        nomb = cajaNombre.getText().toString();
        segundoNomb = cajaSegundoNomb.getText().toString();
        apell= cajaPrimerApell.getText().toString();
        segundoApell = cajaSegundoApell.getText().toString();
        edad = cajaEdad.getText().toString();
        sexo = cajaSexo.getText().toString();

        //Validar
        if (validar()) {

            //Encapsular los valores previamente tomados
            b.putString("Nombre", nomb);
            b.putString("SegundoNombre", segundoNomb);
            b.putString("Apellido", apell);
            b.putString("SegundoApellido", segundoApell);
            b.putString("Edad", edad);
            b.putString("Sexo", sexo);


            i.putExtras(b); // Pasar al Intent los datos en forma encapsulada por el bundle

            startActivity(i); //Arrancar actividad del Intent
        }
    }

    public void borrar(View v){
        cajaNombre.setText("");
        cajaSegundoNomb.setText("");
        cajaPrimerApell.setText("");
        cajaSegundoApell.setText("");
        cajaEdad.setText("");
        cajaSexo.setText("");
    }

    public boolean validar(){
        if (cajaNombre.getText().toString().isEmpty()){
            cajaNombre.setError(getResources().getString(R.string.error_1));
            return false;
        }
        if (cajaSegundoNomb.getText().toString().isEmpty()){
            cajaSegundoNomb.setError(getResources().getString(R.string.error_2));
            return false;
        }
        if (cajaPrimerApell.getText().toString().isEmpty()){
            cajaPrimerApell.setError(getResources().getString(R.string.error_3));
            return false;
        }
        if (cajaSegundoApell.getText().toString().isEmpty()){
            cajaSegundoApell.setError(getResources().getString(R.string.error_4));
            return false;
        }
        if (cajaEdad.getText().toString().isEmpty()){
            cajaEdad.setError(getResources().getString(R.string.error_5));
            return false;
        }
        if (cajaSexo.getText().toString().isEmpty()){
            cajaSexo.setError(getResources().getString(R.string.error_6));
            return false;
        }

        return true;
    }
}















