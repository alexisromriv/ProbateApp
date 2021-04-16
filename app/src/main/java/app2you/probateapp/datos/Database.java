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

        for (int i = 0; i < 20; i++) {
            pregutas1.add(preguntas.get(i));
        }
        temas.add(new Tema("Filósofos Griegos", pregutas1));
        temas.add(new Tema("Alejandro Magno", pregutas1));
        temas.add(new Tema("Necesitamos más temas", pregutas1));
        temas.add(new Tema("No se que inventar", pregutas1));

        for (int i = 0; i < 5; i++) {
            preguntas.get(i).setTema(temas.get(0));
        }
        for (int i = 5; i < 11; i++) {
            preguntas.get(i).setTema(temas.get(1));
        }
        for (int i = 11; i < 16; i++) {
            preguntas.get(i).setTema(temas.get(2));
        }
        for (int i = 16; i < 20; i++) {
            preguntas.get(i).setTema(temas.get(3));
        }

    }

    private void cargarMaterias() {
        List<Tema> temas1 = new ArrayList<>();
        temas1.add(temas.get(0));
        temas1.add(temas.get(1));
        temas1.add(temas.get(2));
        temas1.add(temas.get(3));
        materias.add(new Materia("Imperio Macedonio", "1.jpg", temas1));
    }

    private void cargarRespuestas() {
       // respuestas.add(new Respuesta("Aristóteles", "Aristóteles", true));
       // respuestas.add(new Respuesta("Demóstenes", "Demóstenes", false));
       // respuestas.add(new Respuesta("Sócrates", "Sócrates", false));
       // respuestas.add(new Respuesta("Respuesta 4", "4", true));
       // respuestas.add(new Respuesta("Respuesta 5", "5", false));
       // respuestas.add(new Respuesta("Respuesta 6", "6", false));
        respuestas.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas.add(new Respuesta("Demóstenes","Demóstenes",true));
        respuestas.add(new Respuesta("Sócrates","Sócrates",false));
        respuestas.add(new Respuesta("Pella","Pella",false));
        respuestas.add(new Respuesta("Atenas","Atenas",true));
        respuestas.add(new Respuesta("Mieza","Mieza",false));
        respuestas.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas.add(new Respuesta("Sócrates","Sócrates",true));
        respuestas.add(new Respuesta("Calístenes","Calístenes",false));
        respuestas.add(new Respuesta("Adriano","Adriano",false));
        respuestas.add(new Respuesta("Poncio Pilatos","Pilatos",true));
        respuestas.add(new Respuesta("Julio César","César",false));
        respuestas.add(new Respuesta("Gladio","Gladio",false));
        respuestas.add(new Respuesta("Katana","Katana",true));
        respuestas.add(new Respuesta("Espadus","Espadus",false));
        respuestas.add(new Respuesta("Esculapio o Asclepio","Asclepio",false));
        respuestas.add(new Respuesta("Epitafio","Epitafio",true));
        respuestas.add(new Respuesta("Hipócrates","Hipócrates",false));
        respuestas.add(new Respuesta("Persépolis","Persépolis",false));
        respuestas.add(new Respuesta("Babilonia","Babilonia",true));
        respuestas.add(new Respuesta("Ecbatana","Ecbatana",false));
        respuestas.add(new Respuesta("Irán","Irán",false));
        respuestas.add(new Respuesta("Irak","Irak",true));
        respuestas.add(new Respuesta("Turquía","Turquía",false));
        respuestas.add(new Respuesta("Democracia","Democracia",false));
        respuestas.add(new Respuesta("Oligarquia","Oligarquia",true));
        respuestas.add(new Respuesta("Monarquía","Monarquía",false));
        respuestas.add(new Respuesta("Baco","Baco",false));
        respuestas.add(new Respuesta("Empedocles","Empedocles",true));
        respuestas.add(new Respuesta("ánforo","ánforo",false));
        respuestas.add(new Respuesta("Sócrates","Sócrates",false));
        respuestas.add(new Respuesta("Platón","Platón",true));
        respuestas.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas.add(new Respuesta("Jerjes","Jerjes",false));
        respuestas.add(new Respuesta("Percival","Percival",true));
        respuestas.add(new Respuesta("Abdul Al Hassim","Hassim",false));
        respuestas.add(new Respuesta("La Academia"," Academia",false));
        respuestas.add(new Respuesta("Philos","Philos",true));
        respuestas.add(new Respuesta("Sophia Philo","Sophia",false));
        respuestas.add(new Respuesta("Galos","Galos",false));
        respuestas.add(new Respuesta("Francos","Francos",false));
        respuestas.add(new Respuesta("Franchutes","Franchutes",false));
        respuestas.add(new Respuesta("Edad de la Inocencia","Inocencia",true));
        respuestas.add(new Respuesta("Periodo Nulo","Nulo",true));
        respuestas.add(new Respuesta("Edad Oscura","Oscura",false));
        respuestas.add(new Respuesta("Periodo clásico","clásico",false));
        respuestas.add(new Respuesta("Periodo helenístico","helenístico",false));
        respuestas.add(new Respuesta("Grecia romana","romana",false));
        respuestas.add(new Respuesta("Sócrates","Sócrates",true));
        respuestas.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas.add(new Respuesta("Averroes","Averroes",false));
        respuestas.add(new Respuesta("Teorema de Tales","Tales",true));
        respuestas.add(new Respuesta("Teorema de Euclides","Euclides",true));
        respuestas.add(new Respuesta("Teorema de Pitágoras","Pitágoras",false));
        respuestas.add(new Respuesta("Zeus","Zeus",false));
        respuestas.add(new Respuesta("Apolo","Apolo",false));
        respuestas.add(new Respuesta("Hefesto","Hefesto",true));
        respuestas.add(new Respuesta("Mirón","Mirón",false));
        respuestas.add(new Respuesta("Deméter","Deméter",false));
        respuestas.add(new Respuesta("Fidias","Fidias",true));
        respuestas.add(new Respuesta("Platón","Platón",false));
        respuestas.add(new Respuesta("Hipócrates","Hipócrates",true));
        respuestas.add(new Respuesta("Sofos","Sofos",false));
        respuestas.add(new Respuesta("La conquista romana de Grecia"," romana",false));
        respuestas.add(new Respuesta("La anexión de Grecia con Alejandría","anexión",false));
        respuestas.add(new Respuesta("El derrocamiento del tirano Pisístrato","derrocamiento",true));
        respuestas.add(new Respuesta("En la primera guerra Médica","Médica",false));
        respuestas.add(new Respuesta("En la guerra de Troya*"," Troya",true));
        respuestas.add(new Respuesta("En la guerra del Peloponeso","Peloponeso",false));
        respuestas.add(new Respuesta("Ilíada","Ilíada",false));
        respuestas.add(new Respuesta("Edipo Rey","Edipo",false));
        respuestas.add(new Respuesta("Oda a Afrodita"," Afrodita",false));
        respuestas.add(new Respuesta("PARTENIOS","PARTENIOS",true));
        respuestas.add(new Respuesta("MOTACES","MOTACES",false));
        respuestas.add(new Respuesta("ESPARTIATAS","ESPARTIATAS",false));
        respuestas.add(new Respuesta("HILOTAS","HILOTAS",true));
        respuestas.add(new Respuesta("ESPARTIATAS","ESPARTIATAS",false));
        respuestas.add(new Respuesta("PERIECOS","PERIECOS",false));
        respuestas.add(new Respuesta("UN PUERTO","PUERTO",true));
        respuestas.add(new Respuesta("Una montaña","montaña",false));
        respuestas.add(new Respuesta("Un ágora","ágora",true));
        respuestas.add(new Respuesta("Solón","Solón",false));
        respuestas.add(new Respuesta("Licurgo","Licurgo",false));
        respuestas.add(new Respuesta("Demóstenes","Demóstenes",false));
        respuestas.add(new Respuesta("la ciencia","ciencia",true));
        respuestas.add(new Respuesta("la filosofía","filosofía",true));
        respuestas.add(new Respuesta("ambas","ambas",false));
        respuestas.add(new Respuesta("el orfismo","orfismo",false));
        respuestas.add(new Respuesta("la sofística","sofística",true));
        respuestas.add(new Respuesta("los pitagóricos","pitagóricos",false));
        respuestas.add(new Respuesta("la ciencia debe referirse a lo universal","universal",false));
        respuestas.add(new Respuesta("no es posible la ciencia","no",false));
        respuestas.add(new Respuesta("el -nomos- descansa en la voluntad de los dioses","nomos",false));
        respuestas.add(new Respuesta("Demócrito","Demócrito",true));
        respuestas.add(new Respuesta("Anaxímenes","Anaxímenes",false));
        respuestas.add(new Respuesta("ninguno de los anteriores","ninguno",false));
        respuestas.add(new Respuesta("Demócrito","Demócrito",true));
        respuestas.add(new Respuesta("Empédocles","Empédocles",false));
        respuestas.add(new Respuesta("Heráclito","Heráclito",false));
        respuestas.add(new Respuesta("Heráclito","Heráclito",true));
        respuestas.add(new Respuesta("Jenófanes","Jenófanes",false));
        respuestas.add(new Respuesta("Pitágoras","Pitágoras",false));
        respuestas.add(new Respuesta("una escuela de filosofía y una secta religiosa"," escuela",true));
        respuestas.add(new Respuesta("una escuela de investigación cienÂ­tífica","investigación",false));
        respuestas.add(new Respuesta("todas las anteriores","todas",false));
        respuestas.add(new Respuesta("la virtud es una consecuencia de la naturaleza","naturaleza",true));
        respuestas.add(new Respuesta("la virtud es una consecuencia de la voluntad de los dioses","dioses",false));
        respuestas.add(new Respuesta("en la práctica moral es fundamental el conocimiento","conocimiento",false));
        respuestas.add(new Respuesta("la escuela de Elea","Elea",true));
        respuestas.add(new Respuesta("la escuela socrática","socrática",true));
        respuestas.add(new Respuesta("el orfismo","orfismo",false));
        respuestas.add(new Respuesta("Jenófanes de Colofón","Jenófanes",false));
        respuestas.add(new Respuesta("Tales de Mileto","Tales",false));
        respuestas.add(new Respuesta("Parménides","Parménides",false));
        respuestas.add(new Respuesta("Imperio Acadio","Acadio",true));
        respuestas.add(new Respuesta("Sumeria","Sumeria",true));
        respuestas.add(new Respuesta("Imperio Persa","Persa",false));
        respuestas.add(new Respuesta("Tigris","Tigris",false));
        respuestas.add(new Respuesta("Nilo","Nilo",false));
        respuestas.add(new Respuesta("Ganges","Ganges",true));
        respuestas.add(new Respuesta("Babilonios","Babilonios",false));
        respuestas.add(new Respuesta("Sumerios","Sumerios",true));
        respuestas.add(new Respuesta("Amorreos","Amorreos",false));
        respuestas.add(new Respuesta("Babilonia","Babilonia",false));
        respuestas.add(new Respuesta("Assur","Assur",true));
        respuestas.add(new Respuesta("Uruk","Uruk",false));
        respuestas.add(new Respuesta("Accad","Accad",false));
        respuestas.add(new Respuesta("Babilonia","Babilonia",false));
        respuestas.add(new Respuesta("Persépolis","Persépolis",false));

    }

    private void cargarPreguntas() {
        List<Respuesta> respuestas1 = new ArrayList<>();
        respuestas1.add(respuestas.get(0));
        respuestas1.add(respuestas.get(1));
        respuestas1.add(respuestas.get(2));
        preguntas.add(new Pregunta("Quien participó en la educación y formación académica de Alejandro Magno", respuestas1, null));
        preguntas.add(new Pregunta("Quien fue alumno de Platón", respuestas1,  null));
        preguntas.add(new Pregunta("Emperador Romano que hizo construir un muro en las islas británicas", respuestas1, null));
        preguntas.add(new Pregunta("Nombre de la espada que utilizaban los legionarios", respuestas1, null));
        preguntas.add(new Pregunta("Nombre del Dios de la Salud representado por una serpiente", respuestas1, null));
        preguntas.add(new Pregunta("Capital del Imperio Persa destruída por Alejandro Magno", respuestas1, null));
        preguntas.add(new Pregunta("Que país actual está en territorio de la antigua Persia", respuestas1, null));
        preguntas.add(new Pregunta("Que forma de gobierno tuvo su origen en Grecia", respuestas1, null));
        preguntas.add(new Pregunta("Nombre del dios romano del vino", respuestas1, null));
        preguntas.add(new Pregunta("Quien postuló -yo solo sé que no se nada-", respuestas1, null));
        preguntas.add(new Pregunta("Emperador Persa que combatió contra el Rey Leónidas en la batalla de Termópilas", respuestas1, null));
        preguntas.add(new Pregunta("Nombre de la principal escuela filosófica griega", respuestas1, null));
        preguntas.add(new Pregunta("Nombre de los habitantes de la zona del imperio Romano que hoy es territorio Francés", respuestas1, null));
        preguntas.add(new Pregunta("¿Con qué nombre es conocido el periodo que da comienzo a la historia de la antigua Grecia?", respuestas1, null));
        preguntas.add(new Pregunta("¿Durante qué periodo de la antigua Grecia fue construido el Partenón?", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes no fue un filósofo de la antigua Grecia?", respuestas1, null));
        preguntas.add(new Pregunta("¿Qué famoso teorema matemático establece que -en un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los dos catetos-?", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes dioses de la mitología griega era el dios del cielo y el trueno?", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes no fue un famoso escultor de la antigua Grecia?", respuestas1, null));
        preguntas.add(new Pregunta("¿Quién es conocido como -El padre de la medicina-?", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál fue el resultado final de la Batalla de Corinto?", respuestas1, null));
        preguntas.add(new Pregunta("Según el mito, ¿en qué derivó el rapto (o fuga) de Helena de Esparta?", respuestas1, null));
        preguntas.add(new Pregunta("¿De qué obra literaria Aquiles es principal protagonista?", respuestas1, null));
        preguntas.add(new Pregunta("En la sociedad espartana el grupo social más importante era el de los", respuestas1, null));
        preguntas.add(new Pregunta("Los esclavos en Esparta eran conocidos con el nombre de", respuestas1,  null));
        preguntas.add(new Pregunta("Propio de las poleis era tener unas murallas, una acrópolis y", respuestas1, null));
        preguntas.add(new Pregunta("La creación de las instituciones espartanas se atribuye al legislador", respuestas1, null));
        preguntas.add(new Pregunta("La actitud racional es propia de", respuestas1, null));
        preguntas.add(new Pregunta("El movimiento antiilustrado que aparece en Grecia junto con las primeras reflexiones filosóficas fue", respuestas1, null));
        preguntas.add(new Pregunta("Sócrates influirá en Platón al afirmar que", respuestas1, null));
        preguntas.add(new Pregunta("El filósofo que negó la existencia de las almas fue", respuestas1, null));
        preguntas.add(new Pregunta("La idea de los contrarios se encuentra fundamentalmente en la filosofía de", respuestas1, null));
        preguntas.add(new Pregunta("El primer filósofo en el que aparece la idea de la filosofía como contemplación del espectáculo del mundo fue", respuestas1, null));
        preguntas.add(new Pregunta("La escuela pitagórica era", respuestas1, null));
        preguntas.add(new Pregunta("Para el intelectualismo moral", respuestas1, null));
        preguntas.add(new Pregunta("El movimiento ascético más importante anterior a Platón fue", respuestas1, null));
        preguntas.add(new Pregunta("La crítica al antropomorfismo religioso se encuentra en", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál de las siguientes civilizaciones no tuvo su origen en Mesopotamia?", respuestas1, null));
        preguntas.add(new Pregunta("¿Qué río discurre por Mesopotamia?", respuestas1, null));
        preguntas.add(new Pregunta("¿La rueda fue un invento de los...?", respuestas1, null));
        preguntas.add(new Pregunta("¿En qué ciudad gobernó Hammurabi?", respuestas1, null));
        preguntas.add(new Pregunta("¿Cuál fue la capital del Imperio Acadio?", respuestas1, null));

        for (int i = 1; i < 20 ; i++) {
            List<Respuesta> respuestasLoop = new ArrayList<>();
            respuestasLoop.add(respuestas.get(0));
            respuestasLoop.add(respuestas.get(1));
            respuestasLoop.add(respuestas.get(2));
            preguntas.add(new Pregunta("Pregunta " + i, respuestasLoop, null));
        }
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

