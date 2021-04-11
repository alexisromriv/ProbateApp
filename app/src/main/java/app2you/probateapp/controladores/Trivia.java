package app2you.probateapp.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;

public class Trivia {
    private Tema tema;
    private Pregunta preguntaActual;

    public Trivia(Tema tema) {
        this.tema = tema;
    }

    public Pregunta siguiente(){
        preguntaActual = obtenerPreguntaAleatoria();
        return preguntaActual;
    }

    private Pregunta obtenerPreguntaAleatoria(){
        Random rand = new Random();
        int index = rand.nextInt(tema.getPreguntas().size());
        return tema.getPreguntas().get(index);
    }

    public boolean responder(Respuesta respuesta) {
        return respuesta.isCorrecta();
    }

    public boolean responder(String respuesta) {
        String[] palabras = respuesta.split(" ");
        for (String p:palabras) {
            if (p.equals(preguntaActual.respuestaCorrecta().getPalabraClave())){
                return true;
            }
        }
        return  false;
    }


}
