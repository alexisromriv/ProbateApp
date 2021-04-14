package app2you.probateapp.entidades;

import java.io.Serializable;
import java.util.List;

public class Pregunta implements Serializable {
    private String titulo;
    private List<Respuesta> respuestas;

    public Pregunta(String titulo, List<Respuesta> respuestas) {
        this.titulo = titulo;
        this.respuestas = respuestas;
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

    public Respuesta respuestaCorrecta() {
        for (Respuesta resp : this.getRespuestas()) {
            if (resp.isCorrecta()) {
                return resp;
            }
        }
        return null;
    }
}

