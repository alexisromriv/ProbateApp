package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.controladores.Autenticacion;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Materias;
import app2you.probateapp.entidades.Usuario;

public class Principal extends AppCompatActivity {

    ArrayList<Materias> mismateriasl;
    List<Materia> misMateriasPosta;
   // ArrayList<Materia> listamateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

//        mismateriasl = new ArrayList<Materias>();
//        mismateriasl.add(new Materias("Cultura Griega", "1er. año"));
//        mismateriasl.add(new Materias("Cultura Persa", "1er. año"));
//        mismateriasl.add(new Materias("Macedonia", "1er. año"));

       // listamateria = new ArrayList<Materia>();
     //listamateria.add(new Materia("Cultura Griega", "Pertenon", this, ));




        ArrayList<String> nombreMaterias = new ArrayList<>();


        Usuario usr = null;
        try {
            usr = new Autenticacion().login("alexis", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
        misMateriasPosta = usr.getCurso().getMaterias();

//        for (Materias mismaterias:mismateriasl){
//            nombreMaterias.add(mismaterias.getTextMateria());
//        }


        for (Materia unaMateria:misMateriasPosta){
            nombreMaterias.add(unaMateria.getNombre());
        }


        ListView listamaterias = (ListView) findViewById(R.id.listvmaterias);
        listamaterias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreMaterias));

        listamaterias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(Principal.this, Eleccion.class );
            intent.putExtra("Materia",misMateriasPosta.get(position).getNombre());
            intent.putExtra("Image",misMateriasPosta.get(position).getImagen());
            intent.putExtra("PosMateria",position);
            startActivity(intent);
            }
        });
        TextView tvNombre = findViewById(R.id.hola);
        tvNombre.setText("Hola "+usr.getNombre()+"!!!");

    }

        @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                getMenuInflater().inflate(R.menu.menu_opciones, menu);
                return super.onCreateOptionsMenu(menu);
            }

    }