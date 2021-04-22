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
import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Respuesta;


public class ResultadoExamenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_examen);

    }



}

