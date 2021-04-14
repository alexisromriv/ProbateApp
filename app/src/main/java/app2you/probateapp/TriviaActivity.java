package app2you.probateapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.Trivia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTema;
    private TextView tvPregunta;
    private TextView tvRespuesta1;
    private TextView tvRespuesta2;
    private TextView tvRespuesta3;

    private Trivia trivia;
    private Tema tema;
    private Pregunta pregunta;
    private TextView acertTextView;



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
        tvRespuesta1.setText(pregunta.getRespuestas().get(0).getTitulo());
        tvRespuesta2.setText(pregunta.getRespuestas().get(1).getTitulo());
        tvRespuesta3.setText(pregunta.getRespuestas().get(2).getTitulo());
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

}

