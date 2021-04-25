package app2you.probateapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import app2you.probateapp.controladores.Examen;
import app2you.probateapp.controladores.Trivia;


public class ResultadoTriviaActivity extends AppCompatActivity {

    TextView tvTema;
    TextView tvAciertos;
    TextView tvErrores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_trivia);

        tvTema = findViewById(R.id.tvTemaResultadoTrivia);
        tvAciertos = findViewById(R.id.tvAciertosResultadoTrivia);
        tvErrores = findViewById(R.id.tvErroresResultadoTrivia);

        Intent intent = getIntent();
        Trivia trivia = (Trivia) intent.getSerializableExtra("trivia");
        tvTema.setText(trivia.getTema().getNombre());
        tvAciertos.setText(trivia.getCantidadAciertos() + "");
        tvErrores.setText(trivia.getCantidadErrores() + "");
    }

    public void  volver(View v){
        Intent intent = new Intent(this, Principal.class);
        //intent.putExtra("materia", null);
        startActivity(intent);
    }
    public void sendpage (View view) {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);

    }

}

