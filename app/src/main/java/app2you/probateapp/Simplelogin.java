package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Usuario;

public class Simplelogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplelogin);


        Button buttoningresar = findViewById(R.id.buttoningresar);
        buttoningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView tvusuario = findViewById(R.id.editTextTextEmailAddress);
                TextView tvContrasena = findViewById(R.id.editTextTextPassword);


                Usuario usr = null;
                try {
                    usr = new Autenticacion().login(tvusuario.getText().toString(), tvContrasena.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                if (usr != null) {
                    Toast.makeText(getApplicationContext(), "login succes luego se implementqra la navegacion hacia eln principal" ,Toast.LENGTH_LONG).show();




                    Intent intent = new Intent(v.getContext(), Principal.class);
                    intent.putExtra("posUsuario",usr.getId());

                    startActivityForResult(intent, 0);


                }


              /*  // Intent intent = new Intent(v.getContext(), LoginActivity.class);
                //Intent intent = new Intent(v.getContext(), LoginActivity.class);
               ;*/
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