package app2you.probateapp.entidades;

public class Curso {
    private int id;
    private String nombre;
    private Instituto instituto;

    public Curso(int id, String nombre, Instituto instituto) {
        this.id = id;
        this.nombre = nombre;
        this.instituto = instituto;
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
}
