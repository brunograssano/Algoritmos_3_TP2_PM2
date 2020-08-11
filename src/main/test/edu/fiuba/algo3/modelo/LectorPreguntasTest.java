package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.lector.LectorJson;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.respuestas.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LectorPreguntasTest {

    @Test
    public void test01GeneroPreguntaVoFYUnJugadorDebePoderResponderla() {

        LectorJson lector = new LectorJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        boolean enunciadoEsCorrecto = true;
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2, preguntas.get(19)); //primer VoF en la lista

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);
        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test02GeneroPreguntaMultipleChoiceYUnJugadorDebePoderResponderla() {

        LectorJson lector = new LectorJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2, preguntas.get(0)); //primer multiplechoice en la lista

        OpcionCorrectaMultipleChoice primerRespuestaJugador1 = new OpcionCorrectaMultipleChoice("BrainFuck");
        OpcionCorrectaMultipleChoice segundaRespuestaJugador1 = new OpcionCorrectaMultipleChoice("Clojure");

        OpcionIncorrectaMultipleChoice primerRespuestaJugador2 = new OpcionIncorrectaMultipleChoice("BrainFrick");
        OpcionIncorrectaMultipleChoice segundaRespuestaJugador2 = new OpcionIncorrectaMultipleChoice("HeartFuck");

        ArrayList<OpcionEvaluable> respuestasJugador1MC = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2MC = new ArrayList<>();

        respuestasJugador1MC.add(primerRespuestaJugador1);
        respuestasJugador1MC.add(segundaRespuestaJugador1);

        respuestasJugador2MC.add(primerRespuestaJugador2);
        respuestasJugador2MC.add(segundaRespuestaJugador2);

        RespuestaMultipleChoice respuestasJugador1 = new RespuestaMultipleChoice(respuestasJugador1MC);
        RespuestaMultipleChoice respuestasJugador2 = new RespuestaMultipleChoice(respuestasJugador2MC);

        jugada.procesarJugada(respuestasJugador1,respuestasJugador2);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test03GeneroPreguntaOrderedChoiceYUnJugadorDebePoderResponderla() {

        LectorJson lector = new LectorJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2, preguntas.get(7)); //primer orderedchoice en la lista

        OpcionSimple primerRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(0));
        OpcionSimple segundaRespuestaJugador1 = (OpcionSimple)(jugada.respuestasAPregunta().get(1));
        OpcionSimple tercerRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(2));
        OpcionSimple cuartaRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(3));

        ArrayList<OpcionSimple> respuestasOrderJugador = new ArrayList<>();

        respuestasOrderJugador.add(primerRespuestaJugador1);
        respuestasOrderJugador.add(segundaRespuestaJugador1);
        respuestasOrderJugador.add(tercerRespuestaJugador1);
        respuestasOrderJugador.add(cuartaRespuestaJugador1);

        RespuestaOrderedChoice respuestaJugador1 = new RespuestaOrderedChoice(respuestasOrderJugador);
        RespuestaOrderedChoice respuestaJugador2 = new RespuestaOrderedChoice(respuestasOrderJugador);

        jugada.procesarJugada(respuestaJugador1,respuestaJugador2);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test04GeneroPreguntaGroupChoiceYUnJugadorDebePoderResponderla() {

        LectorJson lector = new LectorJson();
        ArrayList<Pregunta> preguntas = lector.generarPreguntas();
        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2, preguntas.get(13)); //primer groupchoice en la lista

        OpcionSimple primerRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(0));
        OpcionSimple segundaRespuestaJugador1 = (OpcionSimple)(jugada.respuestasAPregunta().get(1));
        OpcionSimple tercerRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(2));
        OpcionSimple cuartaRespuestaJugador1 =  (OpcionSimple)(jugada.respuestasAPregunta().get(3));

        ArrayList<OpcionSimple> respuestasPrimerGrupo = new ArrayList<>() ;
        respuestasPrimerGrupo.add(primerRespuestaJugador1);
        respuestasPrimerGrupo.add(segundaRespuestaJugador1);

        ArrayList<OpcionSimple> respuestasSegundoGrupo = new ArrayList<>();
        respuestasSegundoGrupo.add(tercerRespuestaJugador1);
        respuestasSegundoGrupo.add(cuartaRespuestaJugador1);

        RespuestaGroupChoice respuestaJugador1 = new RespuestaGroupChoice("Frutas",respuestasPrimerGrupo,"Verduras", respuestasSegundoGrupo);
        RespuestaGroupChoice respuestaJugador2 = new RespuestaGroupChoice("Frutas",respuestasPrimerGrupo,"Verduras", respuestasSegundoGrupo);

        jugada.procesarJugada(respuestaJugador1,respuestaJugador2);

        assertEquals(1, jugador1.obtenerPuntos());
    }
}

