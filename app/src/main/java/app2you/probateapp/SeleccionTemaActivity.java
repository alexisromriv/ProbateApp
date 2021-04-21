package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class SeleccionTemaActivity extends AppCompatActivity implements TemasAdapter.OnTemaListener {
    List<Tema> temas;
    RecyclerView recyclerTemas;
    Materia materia;
    TextView tvMateriaTemas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_modalidad);

        try {
            Intent intent = getIntent();
            materia = (Materia) intent.getSerializableExtra("materia");
            temas = materia.getTemas();
            tvMateriaTemas = (TextView)findViewById(R.id.tvMateriaTemas);
            tvMateriaTemas.setText(materia.getNombre());
            recyclerTemas = (RecyclerView) findViewById(R.id.recyclerTemas);
            recyclerTemas.setLayoutManager(new LinearLayoutManager(this));
            TemasAdapter temasAdapter = new TemasAdapter(temas, this);
            recyclerTemas.setAdapter(temasAdapter);
        } catch (Exception ex) {}


    }

    public void onClick(View v){
        try {

        }catch (Exception ex) {

        }

    }

    @Override
    public void onTemaClick(int position) {
        Tema tema = temas.get(position);
        Intent intent = new Intent(SeleccionTemaActivity.this, TriviaActivity.class);
        intent.putExtra("tema", tema);
        startActivity(intent);
    }
}

