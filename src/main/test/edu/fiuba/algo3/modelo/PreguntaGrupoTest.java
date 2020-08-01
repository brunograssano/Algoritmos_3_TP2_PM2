package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;


public class PreguntaGrupoTest {

    @Test
    public void test01SeRespondeCorrectamenteUnaPreguntaGroupChoiceYDevuelve1Punto() {

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Java");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("C#");
        OpcionSimple opcion3Grupo1 = new OpcionSimple("C++");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Python");
        OpcionSimple opcion3Grupo2 = new OpcionSimple("Javascript");


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion3Grupo1);

        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();
        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);
        grupo2Respuesta.add(opcion3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico", grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico", grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo1);
        respuestaGrupo1Jugador.add(opcion3Grupo1);
        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion2Grupo2);
        respuestaGrupo2Jugador.add(opcion3Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(1, resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test02SeRespondeIncorrectamenteUnaPreguntaGroupChoiceYDevuelve0Puntos() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");

        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);

        Grupo grupo1 = new Grupo("Mamiferos",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Reptiles",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test03SeRespondeIncorrectamenteUnaPreguntaGroupChoiceAgregandoMasRespuestasAUnGrupoYDevuelve0Puntos() {

        String enunciado = "Agrupar los segun mamiferos y reptiles";

        OpcionSimple opcion1Grupo1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2Grupo1 = new OpcionSimple("Conejo");
        OpcionSimple opcion1Grupo2 = new OpcionSimple("Lagarto");
        OpcionSimple opcion2Grupo2 = new OpcionSimple("Iguana");


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);

        Grupo grupo1 = new Grupo("Mamiferos",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Reptiles",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);
        respuestaGrupo2Jugador.add(opcion1Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
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


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(opcion1Grupo1);
        grupo1Respuesta.add(opcion2Grupo1);
        grupo1Respuesta.add(opcion3Grupo1);
        grupo2Respuesta.add(opcion1Grupo2);
        grupo2Respuesta.add(opcion2Grupo2);
        grupo2Respuesta.add(opcion3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta preguntaGrupo = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador = new ArrayList<>();

        respuestaGrupo1Jugador.add(opcion1Grupo1);
        respuestaGrupo1Jugador.add(opcion2Grupo1);
        respuestaGrupo1Jugador.add(opcion3Grupo1);
        respuestaGrupo1Jugador.add(opcion1Grupo2);
        respuestaGrupo1Jugador.add(opcion2Grupo2);
        respuestaGrupo1Jugador.add(opcion3Grupo2);


        RespuestaJugadorGroupChoice respuestasJugador = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador, respuestaGrupo2Jugador);
        Resultado resultado = preguntaGrupo.evaluar(respuestasJugador);

        assertEquals(0, resultado.obtenerPuntos().valorNumerico());
    }

}