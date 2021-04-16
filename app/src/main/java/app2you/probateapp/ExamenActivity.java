package app2you.probateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.RespuestaAlumno;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class ExamenActivity extends AppCompatActivity  {
    Examen examen;
    Materia materia;
    private List<RespuestaAlumno> respuestas;
    int preguntaIndex = 0;
    int temaIndex = 0;

    private TextView tvPregunta;
    private TextView tvTema;
    private RadioGroup rgRespuestasExamen;
    private RadioButton rbRespuestaExamen1;
    private RadioButton rbRespuestaExamen2;
    private RadioButton rbRespuestaExamen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        tvPregunta = findViewById(R.id.tvPreguntaExmen);
        tvTema = findViewById(R.id.tvTemaExamen);
        rgRespuestasExamen = (RadioGroup) findViewById(R.id.rgRespuestasExamen);
        rbRespuestaExamen1 = (RadioButton) findViewById(R.id.rbRespuestaExamen1);
        rbRespuestaExamen2 = (RadioButton) findViewById(R.id.rbRespuestaExamen2);
        rbRespuestaExamen3 = (RadioButton) findViewById(R.id.rbRespuestaExamen3);

        try {
            Usuario usr = new Autenticacion().login("alexis", "123");
            materia = usr.getCurso().getMaterias().get(0);

            respuestas = new ArrayList<>();
            for (Tema t : materia.getTemas()) {
                for (Pregunta p : t.getPreguntas()) {
                    respuestas.add(new RespuestaAlumno(p, null));
                }
            }
            temaIndex = 0;
            preguntaIndex = 0;
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
        if(seleccionada == p.getRespuestas().get(0)){
            rbRespuestaExamen1.setChecked(true);
        }
        if(seleccionada == p.getRespuestas().get(1)){
            rbRespuestaExamen2.setChecked(true);
        }
        if(seleccionada == p.getRespuestas().get(2)){
            rbRespuestaExamen3.setChecked(true);
        }

    }

    public void siguiente(View view) {
        seleccionarRespuesta();
        if (preguntaIndex < materia.getTemas().get(temaIndex).getPreguntas().size()) {
            preguntaIndex++;
            setPregunta();
        }
    }

    public void anterior(View view) {
        seleccionarRespuesta();
        if (preguntaIndex > 0) {
            preguntaIndex--;
            setPregunta();
        }
    }

    private void seleccionarRespuesta(){
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

