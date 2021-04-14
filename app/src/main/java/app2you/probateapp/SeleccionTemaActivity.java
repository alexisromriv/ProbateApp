package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class SeleccionTemaActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_modalidad);
    }

    public void onClick(View v){
        try {
            Usuario usr = new Autenticacion().login("alexis", "123");
            Tema tema = usr.getCurso().getMaterias().get(0).getTemas().get(0);
            Intent intent = new Intent(SeleccionTemaActivity.this, TriviaActivity.class);
            intent.putExtra("tema", tema);
            startActivity(intent);
        }catch (Exception ex) {

        }

    }
}

