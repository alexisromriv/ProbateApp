package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


import app2you.probateapp.ui.login.LoginActivity;



public class MainActivity extends AppCompatActivity {



    //public static final String EXTRA_MESSAGE = "com.app2you.probateapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonIngreso = findViewById(R.id.buttonIngreso);
        buttonIngreso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), LoginActivity.class);
                startActivityForResult(intent, 0);
            }

        });
    }




    /** Called when the user taps the Send button */
   // public void sendMessage(View view) {
      //  Intent intent = new Intent(this, LoginActivity.class);
      //  EditText editText = (EditText) findViewById(R.id.editText);
       // String message = editText.getText().toString();
      //  intent.putExtra(EXTRA_MESSAGE, message);
      //  startActivity(intent);
        // Do something in response to button


}
