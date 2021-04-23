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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Respuesta;


public class ResultadoExamenActivity extends AppCompatActivity {
    ExpandableListView elvCorreccion;
    List<String> listGroup = new ArrayList<>();
    HashMap<String, ArrayList<String>> listChild = new HashMap<>();
    ResultadoExamenAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_examen);

        elvCorreccion = findViewById(R.id.elvCorreccion);

        for (int g = 0; g<= 10; g++) {
            listGroup.add("Group " + g);
            ArrayList<String> arrayList = new ArrayList<>();
            for (int c= 0; c <= 5; c++){
                arrayList.add("Item " + c);
            }
            listChild.put(listGroup.get(g), arrayList);
        }

        adapter = new ResultadoExamenAdapter(listGroup, listChild);
        elvCorreccion.setAdapter(adapter);

    }



}

