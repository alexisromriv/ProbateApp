package app2you.probateapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
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
    private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
    private static final int FACTOR_TIEMPO_LECTURA = 110;
    private static final int TIEMPO_ESPERA_RESPUESTA = 4000;

    private Trivia trivia;

    private boolean modoOral = false;
    private boolean leyendo = false;


    private TTSManager ttsManager = null;

    private TextView tvTema;
    private TextView tvPregunta;
    private List<TextView> tvRespuestas = new ArrayList<>();
    private List<TextView> tvClaves = new ArrayList<>();
    private List<LinearLayout> llBotones = new ArrayList<>();

    private ImageView ivAudioOn;
    private ImageView ivAudioOff;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trivia);

        Intent intent = getIntent();
        trivia = new Trivia((Tema) intent.getSerializableExtra("tema"));

        ttsManager = new TTSManager();
        ttsManager.init(this);

        tvTema = findViewById(R.id.tvTemaTrivia);
        tvPregunta = findViewById(R.id.tvPregunta);
        tvRespuestas.add((TextView) findViewById(R.id.tvRespuesta1));
        tvRespuestas.add((TextView) findViewById(R.id.tvRespuesta2));
        tvRespuestas.add((TextView) findViewById(R.id.tvRespuesta3));
        tvClaves.add((TextView) findViewById(R.id.tvClave1));
        tvClaves.add((TextView) findViewById(R.id.tvClave2));
        tvClaves.add((TextView) findViewById(R.id.tvClave3));
        llBotones.add((LinearLayout) findViewById(R.id.llButton1));
        llBotones.add((LinearLayout) findViewById(R.id.llButton2));
        llBotones.add((LinearLayout) findViewById(R.id.llButton3));

        ivAudioOn = findViewById(R.id.ivAudioOn);
        ivAudioOff = findViewById(R.id.ivAudioOff);

        ivAudioOn.setVisibility(View.INVISIBLE);
        ivAudioOff.setVisibility(View.VISIBLE);

        for (LinearLayout ll : llBotones) {
            ll.setOnClickListener(this);
        }

        siguientePregunta();
    }

    private void siguientePregunta() {
        if (trivia.finalizado()) {
            if (modoOral) {
                ttsManager.addQueue("¡Felicitaciones! respondiste todas las preguntas de este tema.");
            }
            Intent intent = new Intent(this, ResultadoTriviaActivity.class);
            intent.putExtra("trivia", trivia);
            startActivity(intent);
            return;
        }

        trivia.siguiente();
        mostrarPregunta();
        if (modoOral) {
            leerPregunta();
            escucharRespuesta();
        }
    }

    private void mostrarPregunta() {
        tvTema.setText(trivia.getTema().getNombre());
        tvPregunta.setText(trivia.getPreguntaActual().getTitulo());
        for (int i = 0; i < 3; i++) {
            llBotones.get(i).setBackgroundColor(ContextCompat.getColor(this, R.color.white));
            tvRespuestas.get(i).setTextColor(ContextCompat.getColor(this, R.color.black));
            tvClaves.get(i).setTextColor(ContextCompat.getColor(this, R.color.black));
            llBotones.get(i).setAlpha(1);
            tvRespuestas.get(i).setText(trivia.getPreguntaActual().getRespuestas().get(i).getTitulo());
            tvClaves.get(i).setText(trivia.getPreguntaActual().getRespuestas().get(i).getPalabraClave());
        }
    }

    private void leerPregunta() {
        leyendo = true;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ttsManager.initQueue(trivia.getPreguntaActual().getTitulo());
                ttsManager.addQueue(trivia.getPreguntaActual().getRespuestas().get(0).getTitulo());
                ttsManager.addQueue(trivia.getPreguntaActual().getRespuestas().get(1).getTitulo());
                ttsManager.addQueue(trivia.getPreguntaActual().getRespuestas().get(2).getTitulo());
            }
        }, 1000);
    }

    private void escucharRespuesta() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                leyendo = false;
                Escuchar(null);
            }
        }, calcularTiempoLectura() + TIEMPO_ESPERA_RESPUESTA);
    }

    private int calcularTiempoLectura() {
        int cantidadCaracteres = trivia.getPreguntaActual().getTitulo().length();
        for (Respuesta r : trivia.getPreguntaActual().getRespuestas()) {
            cantidadCaracteres += r.getTitulo().length();
        }
        return cantidadCaracteres * FACTOR_TIEMPO_LECTURA;
    }


    @Override
    public void onClick(View v) {
        if (modoOral) {
            return;
        }

        switch (v.getId()) {
            case R.id.llButton1:
                responder(trivia.getPreguntaActual().getRespuestas().get(0));
                break;

            case R.id.llButton2:
                responder(trivia.getPreguntaActual().getRespuestas().get(1));
                break;

            case R.id.llButton3:
                responder(trivia.getPreguntaActual().getRespuestas().get(2));
                break;
        }
    }

    private void responder(Respuesta respuesta) {
        quitarOpacidad();
        pintarRespuestaCorrecta();


        int selectedIndex = trivia.getPreguntaActual().getRespuestas().indexOf(respuesta);

        llBotones.get(selectedIndex).setAlpha(1);

        if (!trivia.responder(respuesta)) {
            llBotones.get(selectedIndex).setBackgroundColor(ContextCompat.getColor(this, R.color.red));
            tvRespuestas.get(selectedIndex).setTextColor(ContextCompat.getColor(this, R.color.white));
            tvClaves.get(selectedIndex).setTextColor(ContextCompat.getColor(this, R.color.white));
        }

        if (modoOral) {
            ttsManager.addQueue(respuesta.isCorrecta() ? "¡Correcto!" : "Incorrecto");
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    TriviaActivity.this.siguientePregunta();
                }
            }, 3000);
        } else {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    TriviaActivity.this.siguientePregunta();
                }
            }, 1500);
        }


    }

    private void quitarOpacidad() {
        for (LinearLayout ll : llBotones) {
            ll.setAlpha(.5f);
        }
    }

    private void pintarRespuestaCorrecta() {

        for (int i = 0; i < 3; i++) {
            if (trivia.getPreguntaActual().getRespuestas().get(i).isCorrecta()) {
                llBotones.get(i).setBackgroundColor(ContextCompat.getColor(this, R.color.green));
                tvRespuestas.get(i).setTextColor(ContextCompat.getColor(this, R.color.white));
                tvClaves.get(i).setTextColor(ContextCompat.getColor(this, R.color.white));
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case RECOGNIZE_SPEECH_ACTIVITY:
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    String strSpeech2Text = speech.get(0);
                    Respuesta respuesta = trivia.obtenerRespuestaPorVoz(strSpeech2Text);
                    if (respuesta == null) {
                        ttsManager.addQueue("Repita su respuesta");
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                leerPregunta();
                                escucharRespuesta();
                            }
                        }, 1000);

                        Toast.makeText(this, "Respuesta no reconocida", Toast.LENGTH_SHORT).show();
                    } else {
                        responder(respuesta);
                    }
                }
                break;
            default:
                break;
        }
    }

    public void Escuchar(View view) {
        Intent intentActionRecognizeSpeech = new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH
        );

        intentActionRecognizeSpeech.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");

        try {
            startActivityForResult(intentActionRecognizeSpeech, RECOGNIZE_SPEECH_ACTIVITY);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(this, "Tu dispositivo no soporta reconocimiento de voz", Toast.LENGTH_SHORT).show();
        }

    }


    public void cambiarModo(View view) {
        modoOral = !modoOral;
        if (modoOral) {
            ivAudioOn.setVisibility(View.VISIBLE);
            ivAudioOff.setVisibility(View.INVISIBLE);
            leerPregunta();
            escucharRespuesta();
        } else {
            ivAudioOff.setVisibility(View.VISIBLE);
            ivAudioOn.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(this, "Modo oral " + (modoOral ? "encendido" : "apagado"), Toast.LENGTH_SHORT).show();
    }

    private void reproducir(final String texto, int delay) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                ttsManager.initQueue(texto);
            }
        }, delay);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}

