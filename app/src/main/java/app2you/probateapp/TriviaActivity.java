package app2you.probateapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.controladores.Trivia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;


public class TriviaActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tvTema;
    private TextView tvPregunta;
    private TextView tvRespuesta1;
    private TextView tvRespuesta2;
    private TextView tvRespuesta3;

    private Trivia trivia;
    private Pregunta pregunta;


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
            Usuario usr = new Autenticacion().login("alexis", "123");
            Tema tema = usr.getCurso().getMaterias().get(0).getTemas().get(0);

            trivia = new Trivia(tema);
            pregunta = trivia.siguiente();

            tvTema.setText(tema.getNombre());
            tvPregunta.setText(pregunta.getTitulo());
            tvRespuesta1.setText(pregunta.getRespuestas().get(0).getTitulo());
            tvRespuesta2.setText(pregunta.getRespuestas().get(1).getTitulo());
            tvRespuesta3.setText(pregunta.getRespuestas().get(2).getTitulo());
        }catch (Exception ex){

        }

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvRespuesta1:
                Toast.makeText(this, trivia.responder(pregunta.getRespuestas().get(0)) ? "correcta" : "incorrecta", Toast.LENGTH_SHORT).show();
            case R.id.tvRespuesta2:
                Toast.makeText(this, trivia.responder(pregunta.getRespuestas().get(1)) ? "correcta" : "incorrecta", Toast.LENGTH_SHORT).show();
            case R.id.tvRespuesta3:
                Toast.makeText(this, trivia.responder(pregunta.getRespuestas().get(2)) ? "correcta" : "incorrecta", Toast.LENGTH_SHORT).show();
        }
    }
}
