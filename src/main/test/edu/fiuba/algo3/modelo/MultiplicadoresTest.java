package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadoresTest {

    @Test
    public void test01ElJugadorAplicaMultiplicadorX2AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new MultiplicadorJugador(jugador1,2));

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test02ElJugadorAplicaMultiplicadorX3AUnaPreguntaPenalizableYRespondeCorrectamente(){

        String enunciado = "Slack acepta videollamadas";

        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new MultiplicadorJugador(jugador2,3));

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = new OpcionIncorrectaVerdaderoFalso(!enunciadoNoEsCorrecto);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(-1,jugador1.obtenerPuntos());
        assertEquals(3,jugador2.obtenerPuntos());
    }

    @Test
    public void test03IntentoAgregarUnMultiplicadorEnUnVoFClasicoYRespondiendoNoSeVeAlteradoElResultadoEsperado(){

        String enunciado = "Slack acepta videollamadas";
        boolean enunciadoNoEsCorrecto = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, enunciadoNoEsCorrecto);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);
        jugada.agregarModificador(new MultiplicadorJugador(jugador2,3));

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = new OpcionIncorrectaVerdaderoFalso(!enunciadoNoEsCorrecto);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(enunciadoNoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test04IntentoAgregarUnMultiplicadorEnUnMultipleChoiceClasicoYRespondiendoNoSeVeAlteradoElResultadoEsperado(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        jugada.agregarModificador(new MultiplicadorJugador(jugador2,3));

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();

        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta2);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test05IntentoAgregarUnMultiplicadorEnUnMultipleChoiceParcialYRespondiendoNoSeVeAlteradoElResultadoEsperado(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, preguntaMultipleChoice);

        jugada.agregarModificador(new MultiplicadorJugador(jugador2,3));

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();

        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta2);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1,jugador1.obtenerPuntos());
        assertEquals(2,jugador2.obtenerPuntos());
    }


}

