package app2you.probateapp.entidades;

import java.util.List;

public class Materia {
    private String nombre;
    private String imagen;
    private  List<Tema> temas;

    public Materia(String nombre, String imagen, List<Tema> temas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.temas = temas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}
