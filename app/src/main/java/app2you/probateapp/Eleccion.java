package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Usuario;

public class Eleccion extends AppCompatActivity {

    int posicionparametro;
    private Materia estaMateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);

        Bundle parametro = getIntent().getExtras();
        posicionparametro = parametro.getInt("PosMateria");


        Usuario usr = null;
        try {
            usr = new Autenticacion().login("alexis", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        estaMateria = usr.getCurso().getMaterias().get(posicionparametro);

        TextView tvNombre = findViewById(R.id.textMateria);
        ImageView ivMateria = findViewById(R.id.imageMateria);

        tvNombre.setText(estaMateria.getNombre());

        int id = getResources().getIdentifier(estaMateria.getImagen(), "drawable", getPackageName());
        ivMateria.setImageResource(id);


    }

    public void sendpage(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, SeleccionTemaActivity.class);
        intent.putExtra("PosMateria", posicionparametro);
        intent.putExtra("materia", estaMateria);
        startActivity(intent);
    }

    public void sendexam(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, ExamenPreview.class);
        intent.putExtra("materia", estaMateria);
        startActivity(intent);

    }
}