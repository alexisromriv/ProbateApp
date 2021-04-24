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
    Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);

        materia = (Materia) getIntent().getSerializableExtra("materia");

        TextView tvNombre = findViewById(R.id.textMateria);
        ImageView ivMateria = findViewById(R.id.imageMateria);

        tvNombre.setText(materia.getNombre());

        int id = getResources().getIdentifier(materia.getImagen(), "drawable", getPackageName());
        ivMateria.setImageResource(id);


    }

    public void sendpage(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, SeleccionTemaActivity.class);
        intent.putExtra("materia", materia);
        startActivity(intent);
    }

    public void sendexam(View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, ExamenPreview.class);
        intent.putExtra("materia", materia);
        startActivity(intent);

    }
}