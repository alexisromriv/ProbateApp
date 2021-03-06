package app2you.probateapp.entidades;

import java.io.Serializable;
import java.util.List;

public class Instituto implements Serializable {
    private Integer id;
    private String nombre;

    public Instituto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
