package com.example.soporte.holamundo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Saludo extends AppCompatActivity {

    private TextView mostrar;
    private Bundle b;
    private String aux, nomb,segundoNomb,apell, segundoApell, edad, sexo;
    private Resources res; //Objeto para acceder a los recursos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saludo);

        mostrar = (TextView)findViewById(R.id.txtMostrar);

        //Capturar capsula
        b = getIntent().getExtras();

        //Obtener los datos de la capsula
        nomb = b.getString("Nombre");
        segundoNomb =b.getString("SegundoNombre");
        apell= b.getString("Apellido");
        segundoApell = b.getString("SegundoApellido");
        edad = b.getString("Edad");
        sexo = b.getString("Sexo");



        //Acceder a los recursos
        res =this.getResources();

        //Para que pueda ser en ingles
        aux= res.getString(R.string.parteHola)+" "+nomb+" "+segundoNomb+" "+apell+" "+segundoApell+" "+", "+res.getString(R.string.parteEdad)+" "+edad+" "+res.getString(R.string.parteSexo)+" "+sexo;

        mostrar.setText(aux);

    }
}
