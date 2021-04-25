package app2you.probateapp.controladores;

import app2you.probateapp.entidades.Usuario;
import app2you.probateapp.repositorios.UsuarioDao;

public class Autenticacion {

    private static Usuario usulogeado = null;

    public static Usuario usuariologeado(){
        return usulogeado;
    }


    public Usuario login(String usuario, String contrasena) throws Exception {
        UsuarioDao usuarioDao = new UsuarioDao();
        Usuario resultado = usuarioDao.login(usuario, contrasena);
        if (resultado == null) {
            throw new Exception("Usuario y/o contraseña incorrectos");
        }
        usulogeado = resultado;
        return resultado;
    }

    public Usuario registro(Usuario usuario) {
        UsuarioDao usuarioDao = new UsuarioDao();
        usuarioDao.registrar(usuario);
        return usuario;
    }
}
