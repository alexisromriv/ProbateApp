package app2you.probateapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;


public class ExamenPreview extends AppCompatActivity {
    Materia materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_preview);


        try {
            Intent intent = getIntent();
            materia = (Materia) intent.getSerializableExtra("materia");
            Examen examen = new Examen(materia);

            TextView tvMateria = findViewById(R.id.tvMateriaPreview);
            TextView tvAprobacion = findViewById(R.id.tvAprobacionPreview);
            TextView tvDuracion = findViewById(R.id.tvDuracionPreview);
            TextView tvTemas = findViewById(R.id.tvTemasPreview);

            tvMateria.setText(materia.getNombre());
            tvAprobacion.setText("Porcentaje de aprobación: %" + examen.getAprobacion());
            tvDuracion.setText("Duración estimada: " + examen.getDuracion() +"m");
            tvTemas.setText("Cantidad de temas: " + examen.getTemas().size());

        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void comenzar(View v) {
        Intent intent = new Intent(this, ExamenActivity.class);
        intent.putExtra("materia", materia);
        startActivity(intent);
    }
}