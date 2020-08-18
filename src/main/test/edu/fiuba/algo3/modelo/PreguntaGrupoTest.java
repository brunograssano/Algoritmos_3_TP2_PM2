package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaGrupoTest {

    Jugador jugador;
    ArrayList<OpcionSimple> grupo1Respuesta;
    ArrayList<OpcionSimple> grupo2Respuesta;

    ArrayList<OpcionSimple> respuestaGrupo1Jugador;
    ArrayList<OpcionSimple> respuestaGrupo2Jugador;

    @BeforeEach
    public void setUp(){
        jugador = new Jugador("Prueba");
        grupo1Respuesta = new ArrayList<>();
        grupo2Respuesta = new ArrayList<>();
        respuestaGrupo1Jugador = new ArrayList<>();
        respuestaGrupo2Jugador = new ArrayList<>();
    }

    @Test
    public void test01SeRespondeCorrectamenteUnaPreguntaGroupChoiceYDevuelve1Punto() {
        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Java");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("C#");
        OpcionSimple opcion3Grupo1 = new OpcionSimple("C++");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Python");
        OpcionSimple opcion3Grupo2 = new OpcionSimple("Javascript");

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion3Grupo1);

        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);
        grupo2Respuesta.add(opcion3Grupo2);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado,"Tipado estatico", grupo1Respuesta, "Tipado dinamico", grupo2Respuesta);

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo1);
        respuestaGrupo1Jugador.add(opcion3Grupo1);

        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion2Grupo2);
        respuestaGrupo2Jugador.add(opcion3Grupo2);

        RespuestaGroupChoice respuestasJugador = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador,"Tipado dinamico", respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.responder(respuestasJugador,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
    }

    @Test
    public void test02SeRespondeIncorrectamenteUnaPreguntaGroupChoiceYDevuelve0Puntos() {
        String enunciado = "Agrupar los segun mamiferos y reptiles";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado,"Mamiferos", grupo1Respuesta,"Reptiles", grupo2Respuesta);

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo2);

        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);

        RespuestaGroupChoice respuestasJugador = new RespuestaGroupChoice("Mamiferos", respuestaGrupo1Jugador,"Reptiles", respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.responder(respuestasJugador,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test03SeRespondeIncorrectamenteUnaPreguntaGroupChoiceAgregandoMasRespuestasAUnGrupoYDevuelve0Puntos() {
        String enunciado = "Agrupar los segun mamiferos y reptiles";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado,"Mamiferos", grupo1Respuesta,"Reptiles", grupo2Respuesta);

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo2);

        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);

        RespuestaGroupChoice respuestasJugador = new RespuestaGroupChoice("Mamiferos", respuestaGrupo1Jugador,"Reptiles" ,respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.responder(respuestasJugador,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

    @Test
    public void test04SeRespondeIncorrectamenteUnaPreguntaGroupChoiceMetiendoTodoAUnGrupoYDevuelveCeroPuntos() {
        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Java");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("C#");
        OpcionSimple opcion3Grupo1 = new OpcionSimple("C++");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Python");
        OpcionSimple opcion3Grupo2 = new OpcionSimple("Javascript");

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion3Grupo1);

        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);
        grupo2Respuesta.add(opcion3Grupo2);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado,"Tipado estatico", grupo1Respuesta,"Tipado dinamico", grupo2Respuesta);

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo1);
        respuestaGrupo1Jugador.add(opcion3Grupo1);
        respuestaGrupo1Jugador.add(opcion1Grupo2);
        respuestaGrupo1Jugador.add(opcion2Grupo2);
        respuestaGrupo1Jugador.add(opcion3Grupo2);

        RespuestaGroupChoice respuestasJugador = new RespuestaGroupChoice("Tipado estatico",respuestaGrupo1Jugador,"Tipado dinamico", respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.responder(respuestasJugador,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }

}