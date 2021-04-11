package app2you.probateapp.controladores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app2you.probateapp.entidades.Usuario;
import app2you.probateapp.repositorios.UsuarioDao;

public class AutenticacionTest {
    private Autenticacion auth = null;

    @Before
    public void init() {
        auth = new Autenticacion();
    }

    @Test
    public void loginValido() throws Exception {
        Assert.assertNotNull(auth.login("alexis", "123"));
    }

    @Test
    public void loginInvalido()  {

        try {
            Usuario usuario = auth.login("alexis", "1235");
        } catch (Exception ex) {
            Assert.assertTrue(true);
        }

    }

    @Test
    public void registroValido() throws Exception {
        Usuario nuevoUsuario = new Usuario(null, "Jose", "Perez", "josepe", "123");
        auth.registro(nuevoUsuario);
        Assert.assertNotNull(auth.login("josepe", "123"));
    }


}
