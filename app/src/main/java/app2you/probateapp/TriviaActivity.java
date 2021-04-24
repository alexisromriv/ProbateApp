package app2you.probateapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
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
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta1));
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta2));
        tvRespuestas.add((TextView)findViewById(R.id.tvRespuesta3));
        tvClaves.add((TextView)findViewById(R.id.tvClave1));
        tvClaves.add((TextView)findViewById(R.id.tvClave2));
        tvClaves.add((TextView)findViewById(R.id.tvClave3));

        ivAudioOn = findViewById(R.id.ivAudioOn);
        ivAudioOff = findViewById(R.id.ivAudioOff);

        ivAudioOn.setVisibility(View.INVISIBLE);
        ivAudioOff.setVisibility(View.VISIBLE);

        for (TextView tv : tvRespuestas) {
            tv.setOnClickListener(this);
        }

        siguientePregunta();
    }

    private void siguientePregunta() {
        if (trivia.finalizado()) {
            //Intent intent = new Intent(TriviaActivity.this, ResultadoTriviaActivity.class);
            //intent.putExtra("trivia", trivia);
            //startActivity(intent);
            Toast.makeText(this, "Trivia finalzado", Toast.LENGTH_SHORT).show();
            return;    
        }
        
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
            tv.setText(respuesta.getTitulo());
            tvClaves.get(tvRespuestas.indexOf(tv)).setText(respuesta.getPalabraClave());
        }
        mostrarClaves();
    }

    private void mostrarClaves(){
        for (TextView tv: tvClaves) {
            //tv.setVisibility(modoOral ? View.VISIBLE : View.INVISIBLE);
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
        }, calcularTiempoLectura() + TIEMPO_ESPERA_RESPUESTA);
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
        if (modoOral) {
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
                tvRespuestas.get(trivia.getPreguntaActual().getRespuestas().indexOf(r)).setBackgroundColor(ContextCompat.getColor(this, R.color.green));
            }
        }

        TextView tvSeleccionado = tvRespuestas.get(trivia.getPreguntaActual().getRespuestas().indexOf(respuesta));
        tvSeleccionado.setAlpha(1);
        if (!trivia.responder(respuesta)) {
            tvSeleccionado.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        }
        if (modoOral){
            ttsManager.addQueue(respuesta.isCorrecta() ? "¡Correcto!": "Incorrecto");
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
        if (modoOral){
            ivAudioOn.setVisibility(View.VISIBLE);
            ivAudioOff.setVisibility(View.INVISIBLE);
            leerPregunta();
            escucharRespuesta();
        } else {
            ivAudioOff.setVisibility(View.VISIBLE);
            ivAudioOn.setVisibility(View.INVISIBLE);
        }
        mostrarClaves();

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

