package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Eleccion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eleccion);
    }

    public void sendpage (View view) {
        // Do something in response to button click
        Intent intent = new Intent(this, TriviaActivity.class);
        startActivity(intent);

    }

}