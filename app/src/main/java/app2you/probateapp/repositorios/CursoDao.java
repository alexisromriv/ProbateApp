package app2you.probateapp.repositorios;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Curso;
import app2you.probateapp.entidades.Usuario;

public class CursoDao {
    private List<Curso> cursos;

    private static CursoDao instance;

    public static CursoDao getInstance() {
        if (instance == null) {
            instance = new CursoDao();
        }
        return instance;
    }

    private CursoDao() {
        cursos = new ArrayList<>();
        cursos.add(new Curso(1, "Curso 1",  null));
        cursos.add(new Curso(2, "Curso 2", null));
        cursos.add(new Curso(3, "Curso 3", null));
    }

}
