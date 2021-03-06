package app2you.probateapp.controladores;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.PreguntaConRespuesta;
import app2you.probateapp.entidades.Tema;

public class Examen implements Serializable {
    private static int PREGUNTAS_POR_TEMA = 10;
    private static double FACTOR_DURACION_EXAMEN = 2.3;

    private Materia materia;
    private List<PreguntaConRespuesta> respondidas = new ArrayList<>();
    private int preguntaIndex = -1;
    private double duracionEstimada = 0;
    private int duracion = 0;
    private long start = 0;
    private long end = 0;
    private  int aprobacion;



    public Examen(Materia materia) {
        this.materia = materia;
        for (Tema tema : materia.getTemas()) {
            Collections.shuffle(tema.getPreguntas());
            List<Pregunta> preguntasTema = tema.getPreguntas();
            if (preguntasTema.size() > PREGUNTAS_POR_TEMA) {
                preguntasTema = preguntasTema.subList(0, PREGUNTAS_POR_TEMA);
            }

            for (Pregunta pregunta : preguntasTema) {
                pregunta.setTema(tema);
                respondidas.add(new PreguntaConRespuesta(pregunta, null));
            }
        }
        this.duracionEstimada = cantidadPreguntas() * FACTOR_DURACION_EXAMEN;
        //aprobacion = ThreadLocalRandom.current().nextInt(60, 70);
        aprobacion = 70;
    }

    public void iniciar() {
        start = System.currentTimeMillis();

    }

    public void finalizar() throws Exception {
        if (getPreguntasRestantes() != 0) {
            throw new Exception("Quedan " + getPreguntasRestantes() + " preguntas sin responder");
        }
        end = System.currentTimeMillis();
    }

    private int getPreguntasRestantes() {
        int restantes = 0;
        for (PreguntaConRespuesta pr : respondidas) {
            if (pr.getRespuestaSeleccionada() == null) {
                restantes++;
            }
        }
        return restantes;
    }

    public PreguntaConRespuesta siguiente() {
        if (preguntaIndex < cantidadPreguntas() - 1) {
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

    public boolean aprobado(){
        double porcentajeAciertos =  (double) cantidadAciertos() * 100 / (double) cantidadPreguntas();
        double porcentajeAprobacion = (double) getAprobacion() ;
        boolean aprobado = porcentajeAciertos >= porcentajeAprobacion;
        return aprobado;

    }

    public List<PreguntaConRespuesta> getRespondidas() {
        return respondidas;
    }

    public int getPaso() {
        return this.preguntaIndex + 1;
    }

    public int cantidadPreguntas() {
        return this.getRespondidas().size();
    }

    public PreguntaConRespuesta getPregunta() {
        return this.respondidas.get(preguntaIndex);
    }


    public int getAprobacion() {
        return aprobacion;

    }

    public double getDuracion() {
        return Math.floor(cantidadPreguntas() * FACTOR_DURACION_EXAMEN);
    }

    public List<Tema> getTemas() {
        return materia.getTemas();
    }

    public int cantidadAciertos(){
        int cantidad = 0;
        for (PreguntaConRespuesta pr: respondidas) {
            if (pr.getRespuestaSeleccionada().isCorrecta()){
                cantidad++;
            }
        }
        return cantidad;
    }

    public long tiempoResolucion(){
        return ((end - start) / 1000) / 60 ;
    }
}
