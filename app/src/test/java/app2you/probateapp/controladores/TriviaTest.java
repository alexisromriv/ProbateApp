package app2you.probateapp.controladores;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;
import app2you.probateapp.repositorios.UsuarioDao;

public class TriviaTest {
    Tema tema;

    @Before
    public void init() throws  Exception{
        Usuario usr = new Autenticacion().login("alexis", "123");
        tema = usr.getCurso().getMaterias().get(0).getTemas().get(0);
    }

    @Test
    public void creacionExitosa() {
        Trivia trivia = new Trivia(tema);
    }

    @Test
    public void siguientePregunta() {
        Trivia trivia = new Trivia(tema);
        Pregunta pregunta = trivia.siguiente();
        Assert.assertNotNull(pregunta);
    }

    @Test
    public void responderPorTextoCorrectamente() {
        Trivia trivia = new Trivia(tema);
        Pregunta pregunta = trivia.siguiente();
        String texto = "Test " + pregunta.respuestaCorrecta().getPalabraClave() + " test";
        Assert.assertTrue(trivia.responder(texto));
    }

    @Test
    public void responderPorTextoIncorrectamente() {
        Trivia trivia = new Trivia(tema);
        Pregunta pregunta = trivia.siguiente();
        String texto = "cualquier texto";
        Assert.assertFalse(trivia.responder(texto));
    }

}
