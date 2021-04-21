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

    //obsoleto
    public boolean responder(String respuesta) {
        String[] palabras = respuesta.split(" ");
        //Encontrar palabra clave, luego comprobar si es la correcta, sino respuesta inválida
        for (String p:palabras) {
            if (p.toLowerCase().equals(preguntaActual.respuestaCorrecta().getPalabraClave().toLowerCase())){
                return true;
            }
        }
        return  false;
    }

    public Respuesta obtenerRespuestaPorVoz(String texto) {
        String[] palabras = texto.split(" ");

        for (String p:palabras) {
            for (Respuesta r: preguntaActual.getRespuestas()) {
                if (p.toLowerCase().equals(r.getPalabraClave().toLowerCase())){
                    return r;
                }
            }
        }
        return  null;
    }



}
