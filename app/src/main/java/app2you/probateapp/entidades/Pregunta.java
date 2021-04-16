package app2you.probateapp.entidades;

import java.io.Serializable;
import java.util.List;

public class Pregunta implements Serializable {
    private String titulo;
    private List<Respuesta> respuestas;
    private Tema tema;

    public Pregunta(String titulo, List<Respuesta> respuestas, Tema tema) {
        this.titulo = titulo;
        this.respuestas = respuestas;
        this.tema = tema;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Respuesta respuestaCorrecta() {
        for (Respuesta resp : this.getRespuestas()) {
            if (resp.isCorrecta()) {
                return resp;
            }
        }
        return null;
    }
}

