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

import java.security.spec.ECField;

import app2you.probateapp.controladores.Examen;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.PreguntaConRespuesta;


public class ExamenActivity extends AppCompatActivity {
    Examen examen;
    Materia materia;
    int temaIndex = 0;

    private TextView tvPregunta;
    private TextView tvMateriaExamen;
    private TextView tvTema;
    private TextView tvStepExamen;
    private RadioGroup rgRespuestasExamen;
    private RadioButton rbRespuestaExamen1;
    private RadioButton rbRespuestaExamen2;
    private RadioButton rbRespuestaExamen3;
    private Chronometer chrExamen;

    private Button btnFinalizar;
    private Button btnSiguiente;
    private Button btnAnterior;

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
        btnAnterior = (Button) findViewById(R.id.btnAnterior);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        btnSiguiente = (Button) findViewById(R.id.btnSiguiente);
        chrExamen = (Chronometer) findViewById(R.id.chrExamen);

        try {
            Intent intent = getIntent();
            materia = (Materia) intent.getSerializableExtra("materia");

            examen = new Examen(materia);

            tvMateriaExamen.setText(materia.getNombre());

            temaIndex = 0;

            
            chrExamen.setBase(SystemClock.elapsedRealtime());
            chrExamen.start();
            setPregunta(examen.siguiente());
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    private void setPregunta(PreguntaConRespuesta pr) {
        tvPregunta.setText(pr.getPregunta().getTitulo());
        tvTema.setText(pr.getPregunta().getTema().getNombre());
        rbRespuestaExamen1.setText(pr.getPregunta().getRespuestas().get(0).getTitulo()+ pr.getPregunta().getRespuestas().get(0).isCorrecta());
        rbRespuestaExamen2.setText(pr.getPregunta().getRespuestas().get(1).getTitulo()+ pr.getPregunta().getRespuestas().get(1).isCorrecta());
        rbRespuestaExamen3.setText(pr.getPregunta().getRespuestas().get(2).getTitulo() + pr.getPregunta().getRespuestas().get(2).isCorrecta());
        tvStepExamen.setText(examen.getPaso() + " / " + examen.cantidadPreguntas());

        btnAnterior.setVisibility(View.INVISIBLE);
        btnSiguiente.setVisibility(View.VISIBLE);
        btnFinalizar.setVisibility(View.INVISIBLE);

        if (examen.getPaso() > 1) {
            btnAnterior.setVisibility(View.VISIBLE);
        }

        if (examen.getPaso() == examen.cantidadPreguntas()) {
            btnFinalizar.setVisibility(View.VISIBLE);
            btnSiguiente.setVisibility(View.INVISIBLE);
        }

        seleccionarCheckbox();
    }

    private void seleccionarCheckbox() {
        Respuesta seleccionada = examen.getPregunta().getRespuestaSeleccionada();
        int seleccionadaIndex = examen.getPregunta().getPregunta().getRespuestas().indexOf(seleccionada);
        rgRespuestasExamen.clearCheck();
        rbRespuestaExamen1.setChecked(seleccionadaIndex == 0);
        rbRespuestaExamen2.setChecked(seleccionadaIndex == 1);
        rbRespuestaExamen3.setChecked(seleccionadaIndex == 2);
    }

    public void siguiente(View view) {
        seleccionarRespuesta();
        setPregunta(examen.siguiente());
    }

    public void anterior(View view) {
        seleccionarRespuesta();
        setPregunta(examen.anterior());
    }

    private void seleccionarRespuesta() {
        if (rbRespuestaExamen1.isChecked()) {
            examen.seleccionar(0);
        }
        if (rbRespuestaExamen2.isChecked()) {
            examen.seleccionar(1);
        }
        if (rbRespuestaExamen3.isChecked()) {
            examen.seleccionar(2);
        }
    }

    public void finalizar(View view) {
        try {
            seleccionarRespuesta();
            examen.finalizar();
            Intent intent = new Intent(this, ResultadoExamenActivity.class);
            intent.putExtra("examen", examen);
            int  millis = (int ) (SystemClock.elapsedRealtime() - chrExamen.getBase());
            intent.putExtra("tiempoResolucion", (millis / 1000) / 60);
            startActivity(intent);
        } catch (Exception ex) {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}

