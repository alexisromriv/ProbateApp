package app2you.probateapp.controladores;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.RespuestaAlumno;
import app2you.probateapp.entidades.Tema;

public class Examen {
    private Materia materia;
    private List<RespuestaAlumno> respondidas = new ArrayList<>();

    public Examen(Materia materia) {
        this.materia = materia;
        for (Tema tema: materia.getTemas()) {
            for (Pregunta pregunta: tema.getPreguntas()) {
                pregunta.setTema(tema);
                respondidas.add(new RespuestaAlumno(pregunta, null));
            }
        }
    }

    public void iniciar(){

    }

    public void finalizar(){

    }


}
