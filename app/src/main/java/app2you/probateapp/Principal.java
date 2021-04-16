package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Materias;

public class Principal extends AppCompatActivity {

    ArrayList<Materias> mismateriasl;
   // ArrayList<Materia> listamateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mismateriasl = new ArrayList<Materias>();
        mismateriasl.add(new Materias("CulturaGriega", "1er. año"));
        mismateriasl.add(new Materias("Cultura Persa", "1er. año"));
        mismateriasl.add(new Materias("Macedonia", "1er. año"));

       // listamateria = new ArrayList<Materia>();
     //listamateria.add(new Materia("Cultura Griega", "Pertenon", this, ));


        ArrayList<String> nombreMaterias = new ArrayList<>();

        for (Materias mismaterias:mismateriasl){
            nombreMaterias.add(mismaterias.getTextMateria());
        }

        ListView listamaterias = (ListView) findViewById(R.id.listamaterias);
        listamaterias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreMaterias));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return super.onCreateOptionsMenu(menu);
    }

}