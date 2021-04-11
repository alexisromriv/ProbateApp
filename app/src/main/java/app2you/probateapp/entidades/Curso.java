package app2you.probateapp.entidades;

import java.util.List;

public class Curso {
    private int id;
    private String nombre;
    private Instituto instituto;
    private List<Materia> materias;

    public Curso(int id, String nombre, Instituto instituto, List<Materia> materias) {
        this.id = id;
        this.nombre = nombre;
        this.instituto = instituto;
        this.materias = materias;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
