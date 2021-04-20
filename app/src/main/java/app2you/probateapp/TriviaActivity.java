package app2you.probateapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.TTSManager;
import app2you.probateapp.controladores.Trivia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {
    private TTSManager ttsManager = null;

    private TextView tvTema;
    private TextView tvPregunta;
    private TextView tvRespuesta1;
    private TextView tvRespuesta2;
    private TextView tvRespuesta3;

    private Trivia trivia;
    private Tema tema;
    private Pregunta pregunta;
    private TextView acertTextView;


    private static final int RECOGNIZE_SPEECH_ACTIVITY=1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        tvTema = findViewById(R.id.tvTema);
        tvPregunta = findViewById(R.id.tvPregunta);
        tvRespuesta1 = findViewById(R.id.tvRespuesta1);
        tvRespuesta2 = findViewById(R.id.tvRespuesta2);
        tvRespuesta3 = findViewById(R.id.tvRespuesta3);
        tvRespuesta1.setOnClickListener(this);
        tvRespuesta2.setOnClickListener(this);
        tvRespuesta3.setOnClickListener(this);

        ttsManager = new TTSManager();
        ttsManager.init(this);

        try {
            Intent intent = getIntent();
            tema = (Tema)intent.getSerializableExtra("tema");

            trivia = new Trivia(tema);
            init();

        } catch (Exception ex) {

        }

    }

    private void init() {
        pregunta = trivia.siguiente();
        tvTema.setText(tema.getNombre());
        tvPregunta.setText(pregunta.getTitulo());
        tvRespuesta1.setBackgroundColor(Color.parseColor("#ffffff"));
        tvRespuesta2.setBackgroundColor(Color.parseColor("#ffffff"));
        tvRespuesta3.setBackgroundColor(Color.parseColor("#ffffff"));
        tvRespuesta1.setText(pregunta.getRespuestas().get(0).getTitulo() + "(" + pregunta.getRespuestas().get(0).getPalabraClave() +") " + pregunta.getRespuestas().get(0).isCorrecta());
        tvRespuesta2.setText(pregunta.getRespuestas().get(1).getTitulo()+ "(" + pregunta.getRespuestas().get(1).getPalabraClave() +") "  + pregunta.getRespuestas().get(1).isCorrecta());
        tvRespuesta3.setText(pregunta.getRespuestas().get(2).getTitulo()+ "(" + pregunta.getRespuestas().get(2).getPalabraClave() +") "  + pregunta.getRespuestas().get(2).isCorrecta());
        tvRespuesta1.setAlpha(1);
        tvRespuesta2.setAlpha(1);
        tvRespuesta3.setAlpha(1);
        if (pregunta.getRespuestas().get(0).isCorrecta()){
            acertTextView = tvRespuesta1;
        }
        if (pregunta.getRespuestas().get(1).isCorrecta()){
            acertTextView = tvRespuesta2;
        }
        if (pregunta.getRespuestas().get(2).isCorrecta()){
            acertTextView = tvRespuesta3;
        }
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Escuchar(null);
            }
        }, 6000);
    }


    @Override
    public void onClick(View v) {

        tvRespuesta1.setAlpha(.5f);
        tvRespuesta2.setAlpha(.5f);
        tvRespuesta3.setAlpha(.5f);
        v.setAlpha(1);

        Respuesta respuestaSeleccionada = null;
        switch (v.getId()) {
            case R.id.tvRespuesta1:
                respuestaSeleccionada = this.pregunta.getRespuestas().get(0);
                break;

            case R.id.tvRespuesta2:
                respuestaSeleccionada = this.pregunta.getRespuestas().get(1);
                break;

            case R.id.tvRespuesta3:
                respuestaSeleccionada = this.pregunta.getRespuestas().get(2);
                break;
        }

        acertTextView.setBackgroundColor(Color.parseColor("#28A744"));

        if (trivia.responder(respuestaSeleccionada) ) {
            Toast.makeText(this, "correcta", Toast.LENGTH_SHORT).show();
        } else {
            v.setBackgroundColor(Color.parseColor("#D43341"));
            Toast.makeText(this, "incorrecta", Toast.LENGTH_SHORT).show();
        }


        new Handler().postDelayed(new Runnable() {
            public void run() {
                TriviaActivity.this.init();
            }
        }, 3000);
    }

    private void responder(Respuesta respuesta){
        tvRespuesta1.setAlpha(.5f);
        tvRespuesta2.setAlpha(.5f);
        tvRespuesta3.setAlpha(.5f);

        if (pregunta.getRespuestas().get(0).getPalabraClave() == respuesta.getPalabraClave()) {
            tvRespuesta1.setAlpha(1);
        }
        if (pregunta.getRespuestas().get(1).getPalabraClave() == respuesta.getPalabraClave()) {
            tvRespuesta2.setAlpha(1);
        }
        if (pregunta.getRespuestas().get(2).getPalabraClave() == respuesta.getPalabraClave()) {
            tvRespuesta3.setAlpha(1);
        }


        acertTextView.setBackgroundColor(Color.parseColor("#28A744"));

        if (trivia.responder(respuesta) ) {
            Toast.makeText(this, "correcta", Toast.LENGTH_SHORT).show();
        } else {
            if (pregunta.getRespuestas().get(0).getPalabraClave() == respuesta.getPalabraClave()) {
                tvRespuesta1.setBackgroundColor(Color.parseColor("#D43341"));
            }
            if (pregunta.getRespuestas().get(1).getPalabraClave() == respuesta.getPalabraClave()) {
                tvRespuesta2.setBackgroundColor(Color.parseColor("#D43341"));
            }
            if (pregunta.getRespuestas().get(2).getPalabraClave() == respuesta.getPalabraClave()) {
                tvRespuesta3.setBackgroundColor(Color.parseColor("#D43341"));
            }
            Toast.makeText(this, "incorrecta", Toast.LENGTH_SHORT).show();
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {
                TriviaActivity.this.init();
            }
        }, 3000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RECOGNIZE_SPEECH_ACTIVITY:
                if(resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);
                    Toast.makeText(this, strSpeech2Text, Toast.LENGTH_SHORT).show();
                    Respuesta respuesta = trivia.obtenerRespuestaPorVoz(strSpeech2Text);
                    if (respuesta == null) {
                        Toast.makeText(this, "Respuesta no reconocida", Toast.LENGTH_SHORT).show();
                    } else {
                        responder(respuesta);
                        //Toast.makeText(this, trivia.responder(respuesta) ? "correcta" : "incorrecta", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            default:
                break;
        }
    }

    public void Escuchar(View view){
        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        );

        intentActionRecognizeSpeech.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");

        try {
            startActivityForResult(intentActionRecognizeSpeech, RECOGNIZE_SPEECH_ACTIVITY);
        } catch(ActivityNotFoundException a){
            Toast.makeText(this, "Tu dispositivo no soporta reconocimiento de voz", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}

