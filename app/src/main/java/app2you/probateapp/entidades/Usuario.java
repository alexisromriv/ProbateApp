package app2you.probateapp.entidades;

import java.util.UUID;

public class Usuario {
    private String id;
    private String nombre;
    private String apellido;
    private String usuario;
    private String contrasena;

    public Usuario(String id, String nombre, String apellido, String usuario, String contrasena) {
        if (id == null)  {
            this.id = UUID.randomUUID().toString();
        } else {
            this.id = id;
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
