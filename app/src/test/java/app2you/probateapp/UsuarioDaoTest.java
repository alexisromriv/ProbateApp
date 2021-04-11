package app2you.probateapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app2you.probateapp.entidades.Usuario;
import app2you.probateapp.repositorios.UsuarioDao;

public class UsuarioDaoTest {
    private UsuarioDao dao = null;

    @Before
    public void init() {
        dao = UsuarioDao.getInstance();
    }

    @Test
    public void loginValido() {
        Assert.assertNotNull(dao.login("alexis", "123"));
    }

    @Test
    public void loginInvalido() {
        Assert.assertNull(dao.login("alexis", "1235"));
    }

    @Test
    public void registroValido() {
        Usuario usuario = new Usuario(null,"Test", "Test", "test", "test");
        Assert.assertNotNull(dao.registrar(usuario));
    }

}
