package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Simplelogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplelogin);

        Button buttoningresar = findViewById(R.id.buttoningresar);
        buttoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent intent = new Intent(v.getContext(), LoginActivity.class);
                //Intent intent = new Intent(v.getContext(), LoginActivity.class);
                Intent intent = new Intent(v.getContext(), Principal.class);
                startActivityForResult(intent, 0);
            }

        });

        Button buttonregistro = findViewById(R.id.buttonregistro);
        buttonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Registro.class);
                startActivityForResult(intent, 0);
          }

        });


    }
}