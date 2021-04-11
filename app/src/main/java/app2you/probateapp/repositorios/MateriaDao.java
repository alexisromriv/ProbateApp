package app2you.probateapp.repositorios;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Materia;

public class MateriaDao {
    private  List<Materia> materias;


    public MateriaDao() {
        materias = new ArrayList<>();
        materias.add(new Materia("materia 1", "imagen.jpg", null ));
        materias.add(new Materia("materia 2", "imagen.jpg", null ));
        materias.add(new Materia("materia 3", "imagen.jpg", null ));
    }


}
