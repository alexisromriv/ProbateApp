package app2you.probateapp.controladores;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Tema;

public class Examen {
    private Materia materia;
    private List<PreguntaConRespuesta> respondidas = new ArrayList<>();
    private int preguntaIndex = -1;
    private double duracionEstimada = 0;
    private int duracion = 0;

    public Examen(Materia materia) {
        this.materia = materia;
        for (Tema tema : materia.getTemas()) {
            for (Pregunta pregunta : tema.getPreguntas()) {
                pregunta.setTema(tema);
                respondidas.add(new PreguntaConRespuesta(pregunta, null));
            }
        }
        this.duracionEstimada = cantidadPreguntas() * 1.3;
    }

    public void iniciar() {

    }

    public void finalizar() throws Exception {
        if (getPreguntasRestantes() != 0) {
            throw new Exception("Hay " + getPreguntasRestantes() + " sin responder");
        }
    }

    private int getPreguntasRestantes(){
        int restantes = 0;
        for (PreguntaConRespuesta pr: respondidas) {
            if (pr.getRespuestaSeleccionada() == null) {
                restantes ++;
            }
        }
        return restantes;
    }

    public PreguntaConRespuesta siguiente() {
        if (preguntaIndex < cantidadPreguntas() -1) {
            preguntaIndex++;
        }
        return respondidas.get(preguntaIndex);
    }

    public PreguntaConRespuesta anterior() {
        if (preguntaIndex > 0) {
            preguntaIndex--;
        }
        return respondidas.get(preguntaIndex);
    }

    public void seleccionar(int respuestaIndex) {
        Respuesta resp = respondidas.get(preguntaIndex).getPregunta().getRespuestas().get(respuestaIndex);
        this.respondidas.get(preguntaIndex).setRespuestaSeleccionada(resp);
    }

    public List<PreguntaConRespuesta> getRespondidas() {
        return respondidas;
    }

    public int getPaso(){
        return this.preguntaIndex + 1;
    }
    public int cantidadPreguntas(){
        return this.getRespondidas().size();
    }

    public PreguntaConRespuesta getPregunta(){
        return this.respondidas.get(preguntaIndex);
    }
}
