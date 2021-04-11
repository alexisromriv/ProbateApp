package app2you.probateapp.repositorios;

import app2you.probateapp.datos.Database;
import app2you.probateapp.entidades.Usuario;

public class UsuarioDao {

    private  Database db;


    public UsuarioDao() {
        db = Database.getInstance();
    }

    public Usuario login(String usuario, String contrasena){
        Usuario usu = null;
        for (Usuario u: db.getUsuarios()) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)){
                usu = u;
                break;
            }
        }
        return usu;
    }

    public Usuario registrar(Usuario usuario) {
        db.getUsuarios().add(usuario);
        return usuario;
    }



}
