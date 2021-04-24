package app2you.probateapp.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;

public class Trivia {
    private Tema tema =null;
    private Pregunta preguntaActual = null;
    private List<Pregunta> respondidas = new ArrayList<>();
    public Trivia(Tema tema) {
        this.tema = tema;
    }

    public Pregunta siguiente(){
        if (finalizado()){
            return preguntaActual;
        }

        preguntaActual = obtenerPreguntaAleatoria();
        while (fueRespondida(preguntaActual)) {
            preguntaActual  = obtenerPreguntaAleatoria();
        }
        return preguntaActual;
    }
    private boolean  fueRespondida(Pregunta pregunta){
        for (Pregunta p: respondidas) {
            if (p.equals(pregunta)){
                return true;
            }
        }
        return false;
    }

    public boolean finalizado(){
        return respondidas.size() == tema.getPreguntas().size();
    }

    private Pregunta obtenerPreguntaAleatoria(){
        Random rand = new Random();
        int index = rand.nextInt(tema.getPreguntas().size());
        return tema.getPreguntas().get(index);
    }

    public boolean responder(Respuesta respuesta) {
        respondidas.add(preguntaActual);
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

    public Tema getTema() {
        return tema;
    }

    public Pregunta getPreguntaActual() {
        return preguntaActual;
    }
}
