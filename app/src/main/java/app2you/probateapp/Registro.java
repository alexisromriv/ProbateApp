package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        Spinner spinner = findViewById(R.id.spinner2);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.institutos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        //spinner.setOnItemSelectedListener(this);

        Spinner spinner1 = findViewById(R.id.spinner3);

        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.cursos, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);



    }

    public void sendpage (View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, Simplelogin.class);
        startActivity(intent);


    }
}