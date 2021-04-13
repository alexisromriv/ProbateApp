package app2you.probateapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import app2you.probateapp.entidades.Materias;

public class Principal extends AppCompatActivity {

    ArrayList<Materias> mismateriasl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mismateriasl = new ArrayList<Materias>();
        mismateriasl.add(new Materias("Cultura Griega", "1er. año"));
        mismateriasl.add(new Materias("Cultura Persa", "1er. año"));
        mismateriasl.add(new Materias("Macedonia", "1er. año"));

        ArrayList<String> nombreMaterias = new ArrayList<>();

        for (Materias mismaterias:mismateriasl){
            nombreMaterias.add(mismaterias.getTextMateria());
        }

        ListView listamaterias = (ListView) findViewById(R.id.listamaterias);
        listamaterias.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombreMaterias));

    }

}