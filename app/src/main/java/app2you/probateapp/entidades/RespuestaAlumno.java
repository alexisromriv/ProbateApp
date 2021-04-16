package app2you.probateapp.entidades;

import java.io.Serializable;

public class RespuestaAlumno implements Serializable {
   private Pregunta pregunta;
   private Respuesta respuestaSeleccionada;

    public RespuestaAlumno(Pregunta pregunta, Respuesta respuestaSeleccionada) {
        this.pregunta = pregunta;
        this.respuestaSeleccionada = respuestaSeleccionada;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Respuesta getRespuestaSeleccionada() {
        return respuestaSeleccionada;
    }

    public void setRespuestaSeleccionada(Respuesta respuestaSeleccionada) {
        this.respuestaSeleccionada = respuestaSeleccionada;
    }
}
