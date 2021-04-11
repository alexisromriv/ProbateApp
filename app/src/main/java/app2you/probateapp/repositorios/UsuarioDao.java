package app2you.probateapp.repositorios;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Usuario;

public class UsuarioDao {
    private List<Usuario> usuarios;

    private static UsuarioDao instance;

    public static UsuarioDao getInstance() {
        if (instance == null) {
            instance = new UsuarioDao();
        }
        return instance;
    }


    private UsuarioDao() {
        usuarios = new ArrayList<>();
        registrar(new Usuario(null,"Alexis", "Romero", "alexis", "123"));
    }

    public Usuario login(String usuario, String contrasena){
        Usuario usu = null;
        for (Usuario u: usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContrasena().equals(contrasena)){
                usu = u;
                break;
            }
        }
        return usu;
    }

    public Usuario registrar(Usuario usuario) {
        usuarios.add(usuario);
        return usuario;
    }



}
