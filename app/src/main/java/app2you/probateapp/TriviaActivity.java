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

    private Trivia trivia;

    private boolean modoOral = false;
    private boolean leyendo = false;


    private TTSManager ttsManager = null;

    private TextView tvTema;
    private TextView tvPregunta;
    private List<TextView> tvRespuestas = new ArrayList<>();


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
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta1));
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta2));
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta3));

        for (TextView tv : tvRespuestas) {
            tv.setOnClickListener(this);
        }

        siguientePregunta();
    }

    private void siguientePregunta() {
        trivia.siguiente();
        mostrarPregunta();
        if (modoOral) {
          leerPregunta();
          escucharRespuesta();
        }
    }

    private void mostrarPregunta(){

        tvTema.setText(trivia.getTema().getNombre());
        tvPregunta.setText(trivia.getPreguntaActual().getTitulo());
        for (TextView tv : tvRespuestas) {
            tv.setBackgroundColor(Color.parseColor("#ffffff"));
            tv.setAlpha(1);
            Respuesta respuesta = trivia.getPreguntaActual().getRespuestas().get(tvRespuestas.indexOf(tv));
            tv.setText(respuesta.getTitulo() + "(" + respuesta.getPalabraClave() + ") " + respuesta.isCorrecta());
        }
    }

    private void leerPregunta(){
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

    private void escucharRespuesta(){
        new Handler().postDelayed(new Runnable() {
            public void run() {
                leyendo = false;
                Escuchar(null);
            }
        }, calcularTiempoLectura());
    }

    private int calcularTiempoLectura() {
        int cantidadCaracteres = trivia.getPreguntaActual().getTitulo().length();
        for (Respuesta r: trivia.getPreguntaActual().getRespuestas()) {
            cantidadCaracteres += r.getTitulo().length();
        }
        return cantidadCaracteres * FACTOR_TIEMPO_LECTURA;
    }


    @Override
    public void onClick(View v) {
        if (leyendo) {
            return;
        }

        switch (v.getId()) {
            case R.id.tvRespuesta1:
                responder(trivia.getPreguntaActual().getRespuestas().get(0));
                break;

            case R.id.tvRespuesta2:
                responder(trivia.getPreguntaActual().getRespuestas().get(1));
                break;

            case R.id.tvRespuesta3:
                responder(trivia.getPreguntaActual().getRespuestas().get(2));
                break;
        }
    }

    private void responder(Respuesta respuesta) {
        for (TextView tv : tvRespuestas) {
            tv.setAlpha(.5f);
        }

        for (Respuesta r : trivia.getPreguntaActual().getRespuestas()) {
            if (r.isCorrecta()) {
                tvRespuestas.get(trivia.getPreguntaActual().getRespuestas().indexOf(r)).setBackgroundColor(Color.parseColor("#28A744"));
            }
        }

        TextView tvSeleccionado = tvRespuestas.get(trivia.getPreguntaActual().getRespuestas().indexOf(respuesta));
        tvSeleccionado.setAlpha(1);
        if (!trivia.responder(respuesta)) {
            tvSeleccionado.setBackgroundColor(Color.parseColor("#D43341"));
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {
                TriviaActivity.this.siguientePregunta();
            }
        }, 3000);
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
        Toast.makeText(this, "modo oral " + (modoOral ? "activado" : "desactivado"), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}

