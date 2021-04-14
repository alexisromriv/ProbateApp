package app2you.probateapp.entidades;

import java.io.Serializable;
import java.util.List;

public class Tema  implements Serializable {
    private String nombre;
    private List<Pregunta> preguntas;

    public Tema(String nombre, List<Pregunta> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }
}
