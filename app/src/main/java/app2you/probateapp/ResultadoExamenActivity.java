package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import app2you.probateapp.controladores.Examen;
import app2you.probateapp.datos.Database;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;


public class ResultadoExamenActivity extends AppCompatActivity {
    List<String> listGroup = new ArrayList<>();
    HashMap<String, ArrayList<String>> listChild = new HashMap<>();
    ResultadoExamenAdapter adapter;
    RecyclerView rvRespuestas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_examen);

        rvRespuestas = (RecyclerView)findViewById(R.id.rvRespuestas);
        Materia materia = Database.getInstance().getMaterias().get(0);
        Examen examen = new Examen(materia);
        for (PreguntaConRespuesta pr : examen.getRespondidas()) {
            examen.siguiente();
            int randomNum = ThreadLocalRandom.current().nextInt(0, 3);
            examen.seleccionar(randomNum);
        }
        rvRespuestas.setLayoutManager(new LinearLayoutManager(this));
        ResultadoExamenAdapter adapter = new ResultadoExamenAdapter(examen.getRespondidas());
        rvRespuestas.setAdapter(adapter);
    }


}

