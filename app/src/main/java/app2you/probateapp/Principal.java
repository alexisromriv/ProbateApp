package app2you.probateapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.datos.Database;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Materias;
import app2you.probateapp.entidades.Usuario;

public class Principal extends AppCompatActivity {

    ArrayList<Materias> mismateriasl;
    List<Materia> misMateriasPosta;
    int idparametro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        Bundle parametro = getIntent().getExtras();
        idparametro = parametro.getInt("posUsuario");
        Usuario usr = null;
        ArrayList<Usuario> lisUsuario = (ArrayList<Usuario>) Database.getInstance().getUsuarios();

        for (Usuario usu : lisUsuario) {
            if (usu.getId() == idparametro) {
                usr = usu;
            }
        }

        ArrayList<String> nombreMaterias = new ArrayList<>();

        misMateriasPosta = usr.getCurso().getMaterias();


        for (Materia unaMateria : misMateriasPosta) {
            nombreMaterias.add(unaMateria.getNombre());
        }


        ListView listamaterias = (ListView) findViewById(R.id.listvmaterias);
        listamaterias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreMaterias));

        listamaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Principal.this, Eleccion.class);
                intent.putExtra("Materia", misMateriasPosta.get(position).getNombre());
                intent.putExtra("Image", misMateriasPosta.get(position).getImagen());
                intent.putExtra("PosMateria", position);
                intent.putExtra("materia", misMateriasPosta.get(position));
                startActivity(intent);
            }
        });
        TextView tvNombre = findViewById(R.id.hola);
        tvNombre.setText("Hola " + usr.getNombre() + "!!!");

    }

    @Override
    public void onBackPressed() {
        //no vuelve al login
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.salir:
                Intent intent = new Intent(this, MainActivity.class);
                Toast.makeText(getApplicationContext(), "Hasta luego!!" ,Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;


        }

        return super.onOptionsItemSelected(item);
    }

}