package app2you.probateapp.entidades;

import java.util.List;

public class Instituto {
    private String nombre;
    private List<Materia> materias;

    public Instituto(String nombre, List<Materia> materias) {
        this.nombre = nombre;
        this.materias = materias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
