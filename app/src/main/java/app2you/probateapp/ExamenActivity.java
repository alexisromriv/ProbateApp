package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.RespuestaAlumno;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class ExamenActivity extends AppCompatActivity {
    Examen examen;
    Materia materia;
    private List<RespuestaAlumno> respuestas;
    int preguntaIndex = 0;
    int temaIndex = 0;
    int preguntasLength = 0;

    private TextView tvPregunta;
    private TextView tvMateriaExamen;
    private TextView tvTema;
    private TextView tvStepExamen;
    private RadioGroup rgRespuestasExamen;
    private RadioButton rbRespuestaExamen1;
    private RadioButton rbRespuestaExamen2;
    private RadioButton rbRespuestaExamen3;
    private Chronometer chrExamen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        tvPregunta = findViewById(R.id.tvPreguntaExmen);
        tvTema = findViewById(R.id.tvTemaExamen);
        tvMateriaExamen = (TextView) findViewById(R.id.tvMateriaExamen);
        tvStepExamen = (TextView) findViewById(R.id.tvStepExamen);
        rgRespuestasExamen = (RadioGroup) findViewById(R.id.rgRespuestasExamen);
        rbRespuestaExamen1 = (RadioButton) findViewById(R.id.rbRespuestaExamen1);
        rbRespuestaExamen2 = (RadioButton) findViewById(R.id.rbRespuestaExamen2);
        rbRespuestaExamen3 = (RadioButton) findViewById(R.id.rbRespuestaExamen3);
        chrExamen = (Chronometer) findViewById(R.id.chrExamen);


        try {
            Intent intent = getIntent();

            materia = (Materia) intent.getSerializableExtra("materia");
            tvMateriaExamen.setText(materia.getNombre());

            respuestas = new ArrayList<>();
            for (Tema t : materia.getTemas()) {
                for (Pregunta p : t.getPreguntas()) {
                    respuestas.add(new RespuestaAlumno(p, null));
                    preguntasLength++;
                }
            }
            
            temaIndex = 0;
            preguntaIndex = 0;


            chrExamen.setBase(SystemClock.elapsedRealtime());
            chrExamen.start();
            setPregunta();
        } catch (Exception ex) {
        }
    }


    private void setPregunta() {

        Pregunta p = respuestas.get(preguntaIndex).getPregunta();
        tvPregunta.setText(p.getTitulo());


        rbRespuestaExamen1.setText(p.getRespuestas().get(0).getTitulo());
        rbRespuestaExamen2.setText(p.getRespuestas().get(1).getTitulo());
        rbRespuestaExamen3.setText(p.getRespuestas().get(2).getTitulo());

        Respuesta seleccionada = respuestas.get(preguntaIndex).getRespuestaSeleccionada();
        rgRespuestasExamen.clearCheck();
        if (seleccionada == p.getRespuestas().get(0)) {
            rbRespuestaExamen1.setChecked(true);
        }
        if (seleccionada == p.getRespuestas().get(1)) {
            rbRespuestaExamen2.setChecked(true);
        }
        if (seleccionada == p.getRespuestas().get(2)) {
            rbRespuestaExamen3.setChecked(true);
        }

        tvStepExamen.setText(preguntaIndex + " / " + preguntasLength);

    }

    public void siguiente(View view) {
        seleccionarRespuesta();

        if (preguntaIndex == materia.getTemas().get(temaIndex).getPreguntas().size() - 1 && temaIndex < materia.getTemas().size()) {
            temaIndex++;
            preguntaIndex = 0;
        }

        if (preguntaIndex < materia.getTemas().get(temaIndex).getPreguntas().size()) {
            preguntaIndex++;
            setPregunta();
        }
    }

    public void anterior(View view) {
        seleccionarRespuesta();
        if (preguntaIndex == 0 && temaIndex > 0) {
            temaIndex--;
            preguntaIndex = materia.getTemas().get(temaIndex).getPreguntas().size() - 1;
        }
        if (preguntaIndex > 0) {
            preguntaIndex--;
            setPregunta();
        }
    }

    private void seleccionarRespuesta() {
        if (rbRespuestaExamen1.isChecked()) {
            respuestas.get(preguntaIndex).setRespuestaSeleccionada(respuestas.get(preguntaIndex).getPregunta().getRespuestas().get(0));
        }
        if (rbRespuestaExamen2.isChecked()) {
            respuestas.get(preguntaIndex).setRespuestaSeleccionada(respuestas.get(preguntaIndex).getPregunta().getRespuestas().get(1));
        }
        if (rbRespuestaExamen3.isChecked()) {
            respuestas.get(preguntaIndex).setRespuestaSeleccionada(respuestas.get(preguntaIndex).getPregunta().getRespuestas().get(2));
        }
    }


}

