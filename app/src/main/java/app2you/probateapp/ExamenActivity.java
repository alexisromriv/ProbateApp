package app2you.probateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Usuario;


public class ExamenActivity extends AppCompatActivity  {
    Examen examen;
    Materia materia;
    int preguntaIndex = 0;
    int temaIndex = 0;

    private TextView tvPregunta;
    private RadioButton rbRespuestaExamen1;
    private RadioButton rbRespuestaExamen2;
    private RadioButton rbRespuestaExamen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen);

        tvPregunta = findViewById(R.id.tvPreguntaExmen);
        rbRespuestaExamen1 = (RadioButton)findViewById(R.id.rbRespuestaExamen1);
        rbRespuestaExamen2 = (RadioButton)findViewById(R.id.rbRespuestaExamen2);
        rbRespuestaExamen3 = (RadioButton)findViewById(R.id.rbRespuestaExamen3);

        try {
            Usuario usr = new Autenticacion().login("alexis", "123");
            materia = usr.getCurso().getMaterias().get(0);

            Pregunta pregunta = materia.getTemas().get(temaIndex).getPreguntas().get(preguntaIndex);

            temaIndex = 0;
            preguntaIndex = 0;
            setPregunta();
        } catch (Exception ex) {}
    }

    private void setPregunta() {

        Pregunta p = materia.getTemas().get(temaIndex).getPreguntas().get(preguntaIndex);
        tvPregunta.setText(p.getTitulo());

        rbRespuestaExamen1.setText(p.getRespuestas().get(0).getTitulo());
        rbRespuestaExamen2.setText(p.getRespuestas().get(1).getTitulo());
        rbRespuestaExamen3.setText(p.getRespuestas().get(2).getTitulo());

        rbRespuestaExamen1.setChecked(false);
        rbRespuestaExamen2.setChecked(false);
        rbRespuestaExamen3.setChecked(false);
    }

    public void siguiente(View view){
        if (preguntaIndex < materia.getTemas().get(temaIndex).getPreguntas().size()) {
            preguntaIndex++;
            setPregunta();
        }
    }
    public void anterior(View view){
        if (preguntaIndex > 0) {
            preguntaIndex--;
            setPregunta();
        }
    }


}

