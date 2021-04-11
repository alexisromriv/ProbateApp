package app2you.probateapp.datos;

import androidx.core.content.res.FontResourcesParserCompat;

import java.util.ArrayList;
import java.util.List;

import app2you.probateapp.entidades.Curso;
import app2you.probateapp.entidades.Instituto;
import app2you.probateapp.entidades.Materia;
import app2you.probateapp.entidades.Pregunta;
import app2you.probateapp.entidades.Respuesta;
import app2you.probateapp.entidades.Tema;
import app2you.probateapp.entidades.Usuario;

public class Database {

    private List<Instituto> institutos = new ArrayList<>();
    private List<Curso> cursos = new ArrayList<>();
    private List<Materia> materias = new ArrayList<>();
    private List<Tema> temas = new ArrayList<>();
    private List<Respuesta> respuestas = new ArrayList<>();
    private List<Pregunta> preguntas = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    private static Database instance;

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    private Database() {
        cargarInstitutos();
        cargarRespuestas();
        cargarPreguntas();
        cargarTemas();
        cargarMaterias();
        cargarCursos();
        cargarUsuarios();
    }

    private void cargarInstitutos() {
        institutos.add(new Instituto(1, "Instituto 1"));
    }

    private void cargarCursos() {
        List<Materia> materias1 = new ArrayList<>();
        materias1.add(materias.get(0));
        cursos.add(new Curso(1, "Curso 1", institutos.get(0), materias1));
    }

    private  void cargarTemas() {
        List<Pregunta> pregutas1 = new ArrayList<>();
        pregutas1.add(preguntas.get(0));
        pregutas1.add(preguntas.get(1));
        temas.add(new Tema("Tema 1", pregutas1));
    }

    private void cargarMaterias() {
        List<Tema> temas1 = new ArrayList<>();
        temas1.add(temas.get(0));
        materias.add(new Materia("Materia 1", "1.jpg", temas1));
    }

    private void cargarRespuestas() {
        respuestas.add(new Respuesta("Respuesta 1", "1", true));
        respuestas.add(new Respuesta("Respuesta 2", "2", false));
        respuestas.add(new Respuesta("Respuesta 3", "3", false));
        respuestas.add(new Respuesta("Respuesta 4", "4", true));
        respuestas.add(new Respuesta("Respuesta 5", "5", false));
        respuestas.add(new Respuesta("Respuesta 6", "6", false));
    }

    private void cargarPreguntas() {
        List<Respuesta> respuestas1 = new ArrayList<>();
        respuestas1.add(respuestas.get(0));
        respuestas1.add(respuestas.get(1));
        respuestas1.add(respuestas.get(2));
        preguntas.add(new Pregunta("Pregunta 1", respuestas1));

        List<Respuesta> respuestas2 = new ArrayList<>();
        respuestas2.add(respuestas.get(0));
        respuestas2.add(respuestas.get(1));
        respuestas2.add(respuestas.get(2));
        preguntas.add(new Pregunta("Pregunta 2", respuestas2));
    }

    private void cargarUsuarios() {
        usuarios.add(new Usuario(1, "Alexis", "Romero", "alexis", "123", cursos.get(0)));
        usuarios.add(new Usuario(2, "Gabriel", "Ithurralde", "gabriel", "123", cursos.get(0)));
        usuarios.add(new Usuario(3, "Pabla", "Agorio", "pabla", "123", cursos.get(0)));
    }

    public List<Instituto> getInstitutos() {
        return institutos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}

