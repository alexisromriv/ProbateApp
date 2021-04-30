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
    private List<Materia> materiasIMM = new ArrayList<>();
    private List<Tema> temas = new ArrayList<>();
    private List<Tema> temasIMM = new ArrayList<>();
    private List<Respuesta> respuestas = new ArrayList<>();
    private List<Pregunta> preguntas = new ArrayList<>();
    private List<Pregunta> preguntasIMM = new ArrayList<>();
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
        cargarPreguntas();
        cargarTemas();
        cargarMaterias();
        cargarCursos();
        cargarUsuarios();
    }

    private void cargarInstitutos() {
        institutos.add(new Instituto(1, "Instituto 1"));
        institutos.add(new Instituto(2, "IMM"));
    }

    private void cargarCursos() {
        cursos.add(new Curso(1, "Curso 1", institutos.get(0), materias));
        cursos.add(new Curso(2,"Historia",institutos.get(0),materias));
        cursos.add(new Curso(3,"Mate",institutos.get(0),materias));
        cursos.add(new Curso(4,"Materia3",institutos.get(0),materias));
        cursos.add(new Curso(5,"Materia5",institutos.get(0),materias));
        cursos.add(new Curso(6,"Otro curso",institutos.get(0),materias));
        cursos.add(new Curso(7,"Historia Antigua",institutos.get(0),materias));
        cursos.add(new Curso(8,"Licencia de conducir",institutos.get(1),materiasIMM));

    }

    private  void cargarTemas() {

        List<Pregunta> preguntasInicioSumeria= new ArrayList<>();
        for (int i=0;i<6; i++){
            preguntasInicioSumeria.add(preguntas.get(i));
        }

        List<Pregunta> preguntasFinSumeria= new ArrayList<>();
        for (int i=6;i<10; i++){
            preguntasFinSumeria.add(preguntas.get(i));
        }

        List<Pregunta> preguntasComienzoImperioRomano= new ArrayList<>();
        for (int i=10;i<14; i++){
            preguntasComienzoImperioRomano.add(preguntas.get(i));
        }

        List<Pregunta> preguntasSituacionImperioRomano= new ArrayList<>();
        for (int i=14;i<18; i++){
            preguntasSituacionImperioRomano.add(preguntas.get(i));
        }

        List<Pregunta> preguntasCaidaImperioRomano= new ArrayList<>();
        for (int i=18;i<22; i++){
            preguntasCaidaImperioRomano.add(preguntas.get(i));
        }

        List<Pregunta> preguntasTutankamon= new ArrayList<>();
        for (int i=22;i<26; i++){
            preguntasTutankamon.add(preguntas.get(i));
        }

        List<Pregunta> preguntasNefertiti= new ArrayList<>();
        for (int i=26;i<30; i++){
            preguntasNefertiti.add(preguntas.get(i));
        }

        List<Pregunta> preguntasRomuloRemo= new ArrayList<>();
        for (int i=30;i<34; i++){
            preguntasRomuloRemo.add(preguntas.get(i));
        }

        List<Pregunta> preguntasAlejandroMagno= new ArrayList<>();
        for (int i=34;i<38; i++){
            preguntasAlejandroMagno.add(preguntas.get(i));
        }

        List<Pregunta> preguntasConstantinoElGrande= new ArrayList<>();
        for (int i=38;i<42; i++){
            preguntasConstantinoElGrande.add(preguntas.get(i));
        }


        temas.add(new Tema("Inicio de Sumeria", preguntasInicioSumeria));
        temas.add(new Tema("Fin de Sumeria", preguntasFinSumeria));
        temas.add(new Tema("Comienzo del Imperio romano", preguntasComienzoImperioRomano));
        temas.add(new Tema("Situación del imperio romano", preguntasSituacionImperioRomano));
        temas.add(new Tema("Caída del imperio romano", preguntasCaidaImperioRomano));
        temas.add(new Tema("Tutankamon", preguntasTutankamon));
        temas.add(new Tema("Nefertiti", preguntasNefertiti));
        temas.add(new Tema("Romulo y Remo", preguntasRomuloRemo));
        temas.add(new Tema("Alejandro Magno", preguntasAlejandroMagno));
        temas.add(new Tema("Constantino el grande", preguntasConstantinoElGrande));

        //temas.add(new Tema("Caligula", preguntas));
        //temas.add(new Tema("Alejandro Magno", preguntas));
        //temas.add(new Tema("filósofos Griegos", preguntas));
        //temas.add(new Tema("conquista Europea", preguntas));
        //temas.add(new Tema("armamento romano", preguntas));
        //temas.add(new Tema("Mitología y Cultura Romana", preguntas));
        //temas.add(new Tema("Percia Vs. Grecia", preguntas));
        //temas.add(new Tema("Geografía antigua", preguntas));
        //temas.add(new Tema("Filósofos Griegos", preguntas));
        //temas.add(new Tema("Estados Antiguos", preguntas));

        temasIMM.add(new Tema("Teorico 1", preguntasIMM));

    }

    private void cargarMaterias() {
        materias.add(new Materia("Sumeria","sumeria", temas));
        materias.add(new Materia("Imperio Egipcio","egipcio", temas));
        materias.add(new Materia("Imperio Romano","imperio_romano", temas));
        materias.add(new Materia("Macedonio","macedonio", temas));
        materias.add(new Materia("Imperio Persa","imperio_persa", temas));
        materias.add(new Materia("Cultura Griega","partenon", temas));


        materiasIMM.add(new Materia("Categorias A, G1, G2 y G3", "imm", temasIMM));
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    private void cargarPreguntas() {
        List<Respuesta> respuestas1 = new ArrayList<>();
        respuestas1.add(new Respuesta("Demóstenes","Demóstenes",false));
        respuestas1.add(new Respuesta("Aristóteles","Aristóteles",true));
        respuestas1.add(new Respuesta("Sócrates","Sócrates",false));

        List<Respuesta> respuestas2 = new ArrayList<>();
        respuestas2.add(new Respuesta("Aristóteles","Aristóteles",true));
        respuestas2.add(new Respuesta("Sócrates","Sócrates",false));
        respuestas2.add(new Respuesta("Calístenes","Calístenes",false));

        List<Respuesta> respuestas3 = new ArrayList<>();
        respuestas3.add(new Respuesta("Poncio Pilatos","Pilatos",false));
        respuestas3.add(new Respuesta("Adriano","Adriano",true));
        respuestas3.add(new Respuesta("Julio César","César",false));

        List<Respuesta> respuestas4 = new ArrayList<>();
        respuestas4.add(new Respuesta("Katana","Katana",false));
        respuestas4.add(new Respuesta("Espadus","Espadus",false));
        respuestas4.add(new Respuesta("Gladio","Gladio",true));

        List<Respuesta> respuestas5 = new ArrayList<>();
        respuestas5.add(new Respuesta("Epitafio","Epitafio",false));
        respuestas5.add(new Respuesta("Esculapio o Asclepio","Asclepio",true));
        respuestas5.add(new Respuesta("Hipócrates","Hipócrates",false));

        List<Respuesta> respuestas6 = new ArrayList<>();
        respuestas6.add(new Respuesta("Persépolis","Persépolis",true));
        respuestas6.add(new Respuesta("Babilonia","Babilonia",false));
        respuestas6.add(new Respuesta("Ecbatana","Ecbatana",false));

        List<Respuesta> respuestas7 = new ArrayList<>();
        respuestas7.add(new Respuesta("Irán","Irán",true));
        respuestas7.add(new Respuesta("Irak","Irak",false));
        respuestas7.add(new Respuesta("Turquía","Turquía",false));

        List<Respuesta> respuestas8 = new ArrayList<>();
        respuestas8.add(new Respuesta("Democracia","Democracia",true));
        respuestas8.add(new Respuesta("Oligarquía","Oligarquía",false));
        respuestas8.add(new Respuesta("Monarquía","Monarquía",false));

        List<Respuesta> respuestas9 = new ArrayList<>();
        respuestas9.add(new Respuesta("Anforo","ánforo",false));
        respuestas9.add(new Respuesta("Baco","Baco",true));
        respuestas9.add(new Respuesta("Empedocles","Empedocles",false));

        List<Respuesta> respuestas10 = new ArrayList<>();
        respuestas10.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas10.add(new Respuesta("Sócrates","Sócrates",true));
        respuestas10.add(new Respuesta("Platón","Platón",false));


        List<Respuesta> respuestas11 = new ArrayList<>();
        respuestas11.add(new Respuesta("Jerjes","Jerjes",true));
        respuestas11.add(new Respuesta("Percival","Percival",false));
        respuestas11.add(new Respuesta("Abdul Al Hassim","Hassim",false));

        List<Respuesta> respuestas12 = new ArrayList<>();
        respuestas12.add(new Respuesta("Sophia Philo","Sophia",false));
        respuestas12.add(new Respuesta("La Academia"," Academia",true));
        respuestas12.add(new Respuesta("Philos","Philos",false));

        List<Respuesta> respuestas13 = new ArrayList<>();
        respuestas13.add(new Respuesta("Galos","Galos",true));
        respuestas13.add(new Respuesta("Francos","Francos",false));
        respuestas13.add(new Respuesta("Franchutes","Franchutes",false));

        List<Respuesta> respuestas14 = new ArrayList<>();
        respuestas14.add(new Respuesta("Edad de la Inocencia","Inocencia",false));
        respuestas14.add(new Respuesta("Periodo Nulo","Nulo",false));
        respuestas14.add(new Respuesta("Edad Oscura","Oscura",true));

        List<Respuesta> respuestas15 = new ArrayList<>();
        respuestas15.add(new Respuesta("Periodo clásico","clásico",true));
        respuestas15.add(new Respuesta("Periodo helenístico","helenístico",false));
        respuestas15.add(new Respuesta("Grecia romana","romana",false));

        List<Respuesta> respuestas16 = new ArrayList<>();
        respuestas16.add(new Respuesta("Sócrates","Sócrates",false));
        respuestas16.add(new Respuesta("Aristóteles","Aristóteles",false));
        respuestas16.add(new Respuesta("Averroes","Averroes",true));

        List<Respuesta> respuestas17 = new ArrayList<>();
        respuestas17.add(new Respuesta("Teorema de Tales","Tales",false));
        respuestas17.add(new Respuesta("Teorema de Euclides","Euclides",false));
        respuestas17.add(new Respuesta("Teorema de Pitágoras","Pitágoras",true));

        List<Respuesta> respuestas18 = new ArrayList<>();
        respuestas18.add(new Respuesta("Zeus","Zeus",true));
        respuestas18.add(new Respuesta("Apolo","Apolo",false));
        respuestas18.add(new Respuesta("Hefesto","Hefesto",false));

        List<Respuesta> respuestas19 = new ArrayList<>();
        respuestas19.add(new Respuesta("Mirón","Mirón",false));
        respuestas19.add(new Respuesta("Deméter","Deméter",false));
        respuestas19.add(new Respuesta("Fidias","Fidias",true));

        List<Respuesta> respuestas20 = new ArrayList<>();
        respuestas20.add(new Respuesta("Platón","Platón",false));
        respuestas20.add(new Respuesta("Hipócrates","Hipócrates",true));
        respuestas20.add(new Respuesta("Sofos","Sofos",false));

        List<Respuesta> respuestas21 = new ArrayList<>();
        respuestas21.add(new Respuesta("La conquista romana de Grecia"," romana",true));
        respuestas21.add(new Respuesta("La anexión de Grecia con Alejandría","anexión",false));
        respuestas21.add(new Respuesta("El derrocamiento del tirano Pisístrato","derrocamiento",false));

        List<Respuesta> respuestas22 = new ArrayList<>();
        respuestas22.add(new Respuesta("En la primera guerra Médica","Médica",false));
        respuestas22.add(new Respuesta("En la guerra de Troya*"," Troya",true));
        respuestas22.add(new Respuesta("En la guerra del Peloponeso","Peloponeso",false));

        List<Respuesta> respuestas23 = new ArrayList<>();
        respuestas23.add(new Respuesta("Ilíada","Ilíada",true));
        respuestas23.add(new Respuesta("Edipo Rey","Edipo",false));
        respuestas23.add(new Respuesta("Oda a Afrodita"," Afrodita",false));

        List<Respuesta> respuestas24 = new ArrayList<>();
        respuestas24.add(new Respuesta("Partenios","Partenios",true));
        respuestas24.add(new Respuesta("Motaces","Motaces",false));
        respuestas24.add(new Respuesta("Espartiatas","Espartiatas",false));

        List<Respuesta> respuestas25 = new ArrayList<>();
        respuestas25.add(new Respuesta("Periecos","Periecos",false));
        respuestas25.add(new Respuesta("Hilotas","Hilotas",true));
        respuestas25.add(new Respuesta("Espartiatas","Espartiatas",false));

        List<Respuesta> respuestas26 = new ArrayList<>();
        respuestas26.add(new Respuesta("Un puerto","puerto",false));
        respuestas26.add(new Respuesta("Una montaña","montaña",false));
        respuestas26.add(new Respuesta("Un ágora","ágora",true));

        List<Respuesta> respuestas27 = new ArrayList<>();
        respuestas27.add(new Respuesta("Solón","Solón",false));
        respuestas27.add(new Respuesta("Licurgo","Licurgo",false));
        respuestas27.add(new Respuesta("Demóstenes","Demóstenes",true));

        List<Respuesta> respuestas28 = new ArrayList<>();
        respuestas28.add(new Respuesta("la ciencia","ciencia",true));
        respuestas28.add(new Respuesta("la filosofía","filosofía",false));
        respuestas28.add(new Respuesta("ambas","ambas",false));

        List<Respuesta> respuestas29 = new ArrayList<>();
        respuestas29.add(new Respuesta("el orfismo","orfismo",false));
        respuestas29.add(new Respuesta("la sofística","sofística",true));
        respuestas29.add(new Respuesta("los pitagóricos","pitagóricos",false));

        List<Respuesta> respuestas30 = new ArrayList<>();
        respuestas30.add(new Respuesta("la ciencia debe referirse a lo universal","universal",true));
        respuestas30.add(new Respuesta("no es posible la ciencia","no",false));
        respuestas30.add(new Respuesta("el -nomos- descansa en la voluntad de los dioses","nomos",false));

        List<Respuesta> respuestas31 = new ArrayList<>();
        respuestas31.add(new Respuesta("Demócrito","Demócrito",true));
        respuestas31.add(new Respuesta("Anaxímenes","Anaxímenes",false));
        respuestas31.add(new Respuesta("Ninguno de los anteriores","ninguno",false));

        List<Respuesta> respuestas32 = new ArrayList<>();
        respuestas32.add(new Respuesta("Empédocles","Empédocles",false));
        respuestas32.add(new Respuesta("Demócrito","Demócrito",true));
        respuestas32.add(new Respuesta("Heráclito","Heráclito",false));

        List<Respuesta> respuestas33 = new ArrayList<>();
        respuestas33.add(new Respuesta("Heráclito","Heráclito",true));
        respuestas33.add(new Respuesta("Jenófanes","Jenófanes",false));
        respuestas33.add(new Respuesta("Pitágoras","Pitágoras",false));

        List<Respuesta> respuestas34 = new ArrayList<>();
        respuestas34.add(new Respuesta("Una escuela de filosofía y una secta religiosa"," escuela",true));
        respuestas34.add(new Respuesta("Una escuela de investigación científica","investigación",false));
        respuestas34.add(new Respuesta("Todas las anteriores","todas",false));

        List<Respuesta> respuestas35 = new ArrayList<>();
        respuestas35.add(new Respuesta("La virtud es una consecuencia de la naturaleza","naturaleza",true));
        respuestas35.add(new Respuesta("La virtud es una consecuencia de la voluntad de los dioses","dioses",false));
        respuestas35.add(new Respuesta("En la práctica moral es fundamental el conocimiento","conocimiento",false));

        List<Respuesta> respuestas36 = new ArrayList<>();
        respuestas36.add(new Respuesta("La escuela de Elea","Elea",true));
        respuestas36.add(new Respuesta("La escuela socrática","socrática",true));
        respuestas36.add(new Respuesta("El orfismo","orfismo",false));

        List<Respuesta> respuestas37 = new ArrayList<>();
        respuestas37.add(new Respuesta("Jenófanes de Colofón","Jenófanes",false));
        respuestas37.add(new Respuesta("Tales de Mileto","Tales",true));
        respuestas37.add(new Respuesta("Parménides","Parménides",false));

        List<Respuesta> respuestas38 = new ArrayList<>();
        respuestas38.add(new Respuesta("Imperio Acadio","Acadio",false));
        respuestas38.add(new Respuesta("Sumeria","Sumeria",true));
        respuestas38.add(new Respuesta("Imperio Persa","Persa",false));

        List<Respuesta> respuestas39 = new ArrayList<>();
        respuestas39.add(new Respuesta("Tigris","Tigris",false));
        respuestas39.add(new Respuesta("Nilo","Nilo",false));
        respuestas39.add(new Respuesta("Ganges","Ganges",true));

        List<Respuesta> respuestas40 = new ArrayList<>();
        respuestas40.add(new Respuesta("Babilonios","Babilonios",false));
        respuestas40.add(new Respuesta("Sumerios","Sumerios",true));
        respuestas40.add(new Respuesta("Amorreos","Amorreos",false));

        List<Respuesta> respuestas41 = new ArrayList<>();
        respuestas41.add(new Respuesta("Babilonia","Babilonia",false));
        respuestas41.add(new Respuesta("Assur","Assur",true));
        respuestas41.add(new Respuesta("Uruk","Uruk",false));

        List<Respuesta> respuestas42 = new ArrayList<>();
        respuestas42.add(new Respuesta("Accad","Accad",false));
        respuestas42.add(new Respuesta("Babilonia","Babilonia",false));
        respuestas42.add(new Respuesta("Persépolis","Persépolis",true));




        preguntas.add(new Pregunta("Quien participó en la educación y formación académica de Alejandro Magno", respuestas1, null));
        preguntas.add(new Pregunta("Quien fue alumno de Platón", respuestas2,  null));
        preguntas.add(new Pregunta("Emperador Romano que hizo construir un muro en las islas británicas", respuestas3, null));
        preguntas.add(new Pregunta("Nombre de la espada que utilizaban los legionarios", respuestas4, null));
        preguntas.add(new Pregunta("Nombre del Dios de la Salud representado por una serpiente", respuestas5, null));
        preguntas.add(new Pregunta("Capital del Imperio Persa destruída por Alejandro Magno", respuestas6, null));
        preguntas.add(new Pregunta("Que país actual está en territorio de la antigua Persia", respuestas7, null));
        preguntas.add(new Pregunta("Que forma de gobierno tuvo su origen en Grecia", respuestas8, null));
        preguntas.add(new Pregunta("Nombre del dios romano del vino", respuestas9, null));
        preguntas.add(new Pregunta("Quien postuló: yo solo sé que no sé nada", respuestas10, null));
        preguntas.add(new Pregunta("Emperador Persa que combatió contra el Rey Leónidas en la batalla de Termópilas", respuestas11, null));
        preguntas.add(new Pregunta("Nombre de la principal escuela filosófica griega", respuestas12, null));
        preguntas.add(new Pregunta("Nombre de los habitantes de la zona del imperio Romano que hoy es territorio Francés", respuestas13, null));
        preguntas.add(new Pregunta("¿Con qué nombre es conocido el periodo que da comienzo a la historia de la antigua Grecia?", respuestas14, null));
        preguntas.add(new Pregunta("¿Durante qué periodo de la antigua Grecia fue construido el Partenón?", respuestas15, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes no fue un filósofo de la antigua Grecia?", respuestas16, null));
        preguntas.add(new Pregunta("¿Qué famoso teorema matemático establece que -en un triángulo rectángulo, el cuadrado de la hipotenusa es igual a la suma de los cuadrados de los dos catetos-?", respuestas17, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes dioses de la mitología griega era el dios del cielo y el trueno?", respuestas18, null));
        preguntas.add(new Pregunta("¿Cuál de los siguientes no fue un famoso escultor de la antigua Grecia?", respuestas19, null));
        preguntas.add(new Pregunta("¿Quién es conocido como: El padre de la medicina?", respuestas20, null));
        preguntas.add(new Pregunta("¿Cuál fue el resultado final de la Batalla de Corinto?", respuestas21, null));
        preguntas.add(new Pregunta("Según el mito, ¿en qué derivó el rapto (o fuga) de Helena de Esparta?", respuestas22, null));
        preguntas.add(new Pregunta("¿De qué obra literaria Aquiles es principal protagonista?", respuestas23, null));
        preguntas.add(new Pregunta("En la sociedad espartana el grupo social más importante era el de los", respuestas24, null));
        preguntas.add(new Pregunta("Los esclavos en Esparta eran conocidos con el nombre de", respuestas25,  null));
        preguntas.add(new Pregunta("Propio de las poleis era tener unas murallas, una acrópolis y", respuestas26, null));
        preguntas.add(new Pregunta("La creación de las instituciones espartanas se atribuye al legislador", respuestas27, null));
        preguntas.add(new Pregunta("La actitud racional es propia de", respuestas28, null));
        preguntas.add(new Pregunta("El movimiento antiilustrado que aparece en Grecia junto con las primeras reflexiones filosóficas fue", respuestas29, null));
        preguntas.add(new Pregunta("Sócrates influirá en Platón al afirmar que", respuestas30, null));
        preguntas.add(new Pregunta("El filósofo que negó la existencia de las almas fue", respuestas31, null));
        preguntas.add(new Pregunta("La idea de los contrarios se encuentra fundamentalmente en la filosofía de", respuestas32, null));
        preguntas.add(new Pregunta("El primer filósofo en el que aparece la idea de la filosofía como contemplación del espectáculo del mundo fue", respuestas33, null));
        preguntas.add(new Pregunta("La escuela pitagórica era", respuestas34, null));
        preguntas.add(new Pregunta("Para el intelectualismo moral", respuestas35, null));
        preguntas.add(new Pregunta("El movimiento ascético más importante anterior a Platón fue", respuestas36, null));
        preguntas.add(new Pregunta("La crítica al antropomorfismo religioso se encuentra en", respuestas37, null));
        preguntas.add(new Pregunta("¿Cuál de las siguientes civilizaciones no tuvo su origen en Mesopotamia?", respuestas38, null));
        preguntas.add(new Pregunta("¿Qué río discurre por Mesopotamia?", respuestas39, null));
        preguntas.add(new Pregunta("¿La rueda fue un invento de los...?", respuestas40, null));
        preguntas.add(new Pregunta("¿En qué ciudad gobernó Hammurabi?", respuestas41, null));
        preguntas.add(new Pregunta("¿Cuál fue la capital del Imperio Acadio?", respuestas42, null));

        //------------------ IMMM -------------//

        List<Respuesta> respuestasIMM1 = new ArrayList<>();
        respuestasIMM1.add(new Respuesta("Si un vehículo situado detrás del suyo comenzó la maniobra para adelantarlo a usted.", "Maniobra", false));
        respuestasIMM1.add(new Respuesta("A un vehículo detenido momentáneamente en una cebra o cruce peatonal", "Cebra", false));
        respuestasIMM1.add(new Respuesta("Se podrá adelantar por la derecha a un vehículo que haya indicado la intención de girar a la izquierda", "Girar", true));

        List<Respuesta> respuestasIMM2 = new ArrayList<>();
        respuestasIMM2.add(new Respuesta("Detención obligaroria", "Detención", true));
        respuestasIMM2.add(new Respuesta("Avance", "Avance", false));
        respuestasIMM2.add(new Respuesta("Aminore", "Aminore", false));

        List<Respuesta> respuestasIMM3 = new ArrayList<>();
        respuestasIMM3.add(new Respuesta("Son líneas diagonales entre líneas continuas que sirven para separar carriles.", "detencion", true));
        respuestasIMM3.add(new Respuesta("Está permitido circular sobre ellas.", "avance", false));
        respuestasIMM3.add(new Respuesta("Está permitido estacionar sobre ellas.", "aminore", false));

        List<Respuesta> respuestasIMM4 = new ArrayList<>();
        respuestasIMM4.add(new Respuesta("Vehículos de hasta 9 pasajeros, vehículos con remolque, con un peso máx. Total de hasta 4000kg.", "Nueve", true));
        respuestasIMM4.add(new Respuesta("Motocicletas sin límite de cilindrada", "Motocicletas", false));
        respuestasIMM4.add(new Respuesta("Vehículos de hasta 18 pasajeros y camiones simples, pudiendo llevar remolque que no sobrepase los 1500kg", "Dieciocho", false));

        List<Respuesta> respuestasIMM5 = new ArrayList<>();
        respuestasIMM5.add(new Respuesta("Los automóviles no necesitan luces de marcha atrás", "Ninguna", false));
        respuestasIMM5.add(new Respuesta("En automóviles deben ser rojas y de mayor intensidad que las de posición, se encenderán al oprimir el freno.", "Rojas", false));
        respuestasIMM5.add(new Respuesta("En automóviles deben ser blancas. Se encenderá al ponerse la marcha atrás.", "Blancas", true));

        List<Respuesta> respuestasIMM6 = new ArrayList<>();
        respuestasIMM6.add(new Respuesta("A) No girar sobre la misma calzada en sentido opuesto, ni cerca de curvas, puentes, túneles, estructuras elevadas, pasos a nivel, cimas de cuestas y cruces ferroviarios ni aun en lugares permitidos cuando constituya un riesgo para la seguridad y obstaculice la libre circulacion", "A", true));
        respuestasIMM6.add(new Respuesta("B) Para girar a la derecha, previamente ubicarse en el carril de circulación de más a la izquierda, y poner las señales de giro obligatorio. Ingresará a la nueva vía, por el lado correspondiente a la circulación, en el carril de más a la izquierda, en su sentido de marcha.", "B", false));
        respuestasIMM6.add(new Respuesta("C) Cambios de dirección, disminución de velocidad y demás maniobras que alteran la marcha de un vehículo, serán reglamentaria y anticipadamente advertidas. Se efectuarán aunque atentan contra la seguridad o la fluidez del tránsito.", "C", false));

        List<Respuesta> respuestasIMM7 = new ArrayList<>();
        respuestasIMM7.add(new Respuesta("Cuando dos vehículos se crucen en una intersección no señalizada, el conductor que observase a otro aproximarse por su derecha, cederá el paso.", "Derecha", true));
        respuestasIMM7.add(new Respuesta("En cruces donde existan carteles de  “PARE” y “CEDA EL PASO” igual regirá la norma establecida en el numeral anterior.", "PARE", false));
        respuestasIMM7.add(new Respuesta("El vehículo que cambia de dirección o de sentido de marcha, tiene preferencia de paso sobre los demás.", "Dirección", false));

        List<Respuesta> respuestasIMM8 = new ArrayList<>();
        respuestasIMM8.add(new Respuesta("A) Luz roja intermitente: los vehículos que la enfrenten deben detenerse inmediatamente antes de ella y el derecho a seguir queda sujeto a las normas que rigen después de haberse detenido en un signo de “PARE”.", "A", false));
        respuestasIMM8.add(new Respuesta("B) Luz amarilla o ámbar continua: el conductor que deberá tomar las precauciones necesarias para detenerse a menos que se encuentre en una zona de cruce o a una distancia tal, que su detención coloque en riesgo la seguridad del tránsito.", "B", false));
        respuestasIMM8.add(new Respuesta("C) Ambas opciones anteriores son correctas", "C", true));

        List<Respuesta> respuestasIMM9 = new ArrayList<>();
        respuestasIMM9.add(new Respuesta("A) Indica que se permite adelantar.", "A", false));
        respuestasIMM9.add(new Respuesta("B) Se permite adelantar si hay visibilidad y el carril opuesto se encuentra desocupado en un espacio suficiente", "B", false));
        respuestasIMM9.add(new Respuesta("C) No deben ser transpuestas o circular sobre ellas bajo ninguna circunstancia, ya que representan una separación física.", "C", true));

        List<Respuesta> respuestasIMM10 = new ArrayList<>();
        respuestasIMM10.add(new Respuesta("Arrancar el motor pisando firmemente el acelerador", "Acelerador", false));
        respuestasIMM10.add(new Respuesta("Usar primera solo para iniciar la marcha, pasar a seguna a los 2 segundos o seis metros aproximadamente", "Primera", true));
        respuestasIMM10.add(new Respuesta("Circular lo menos posible en los cambios más ligeros y mantener altas las revoluciones", "Altas", false));


        preguntasIMM.add(new Pregunta("Se puede adelantar a otro vehículo:", respuestasIMM1, null));
        preguntasIMM.add(new Pregunta("Señales de transito manuales. El agente de tránsito en posición de frente o espaldas significa:", respuestasIMM2, null));
        preguntasIMM.add(new Pregunta("Señalización horizontal. Las zonas o áreas neutrales:", respuestasIMM3, null));
        preguntasIMM.add(new Pregunta("Con una licencia categoría A estpy habilitado a conducir", respuestasIMM4, null));
        preguntasIMM.add(new Pregunta("Luces. Un vehículo en condiciones reglamentarias debe tener en buen funcionamiento sus luces, la de marcha atrás debe ser:", respuestasIMM5, null));
        preguntasIMM.add(new Pregunta("Giros. Cual de las soguientes afirmaciones es correcta:", respuestasIMM6, null));
        preguntasIMM.add(new Pregunta("Preferencias de paso. Indique la opción correcta", respuestasIMM7, null));
        preguntasIMM.add(new Pregunta("Semáforos. Indique la opción correcta.", respuestasIMM8, null));
        preguntasIMM.add(new Pregunta("Líneas centrales. Si hay  2 líneas centrales continuas:", respuestasIMM9, null));
        preguntasIMM.add(new Pregunta("Para lograr una conducción ecológicamente eficiente es clave", respuestasIMM10, null));

    }

    private void cargarUsuarios() {
        usuarios.add(new Usuario(1, "Alexis", "Romero", "alexis@probateapp.com", "123", cursos.get(0)));
        usuarios.add(new Usuario(2, "Gabriel", "Ithurralde", "gabriel@probateapp.com", "123", cursos.get(0)));
        usuarios.add(new Usuario(3, "Pabla", "Agorio", "pabla@probateapp.com", "123", cursos.get(0)));
        usuarios.add(new Usuario(4, "Evaluador", "b_IT", "evaluador@probateapp.com", "abc123", cursos.get(7)));
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}

