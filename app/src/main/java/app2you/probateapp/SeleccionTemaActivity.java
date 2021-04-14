package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class SeleccionTemaActivity extends AppCompatActivity  {
    List<Tema> temas;
    RecyclerView recyclerTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_modalidad);

        try {
            Usuario usr = new Autenticacion().login("alexis", "123");
            temas = usr.getCurso().getMaterias().get(0).getTemas();
            recyclerTemas = (RecyclerView) findViewById(R.id.recyclerTemas);
            recyclerTemas.setLayoutManager(new LinearLayoutManager(this));
            TemasAdapter temasAdapter = new TemasAdapter(temas);
            recyclerTemas.setAdapter(temasAdapter);
        } catch (Exception ex) {}


    }

    public void onClick(View v){
        try {
            Tema tema = temas.get(0);
            Intent intent = new Intent(SeleccionTemaActivity.this, TriviaActivity.class);
            intent.putExtra("tema", tema);
            startActivity(intent);
        }catch (Exception ex) {

        }

    }
}

