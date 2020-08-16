package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExclusividadTest {

    @Test
    public void test01UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoVoFClasico(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test02SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntosVoFClasico(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        jugada.agregarModificador(new Exclusividad(jugador2));
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test03AmbosJugadoresRespondenBienNingunoGanaPuntosVoFClasico(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test04AmbosJugadoresRespondenMalSiguenConCeroPuntosVoFClasico(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = new OpcionIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test05AlIntentarAplicarExclusividadEnUnaPreguntaVoFPenalizableSeContinuaSinCambios(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = new OpcionCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }


    @Test
    public void test06UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoMCClasico(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");


        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test07SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntosMCClasico(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");


        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test08AmbosJugadoresRespondenBienNingunoGanaPuntosMCClasico(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");


        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta2);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test09AmbosJugadoresRespondenMalSiguenConCeroPuntosMCClasico(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");


        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test10UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoMCParcial(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test11SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntosMCParcial(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test12AmbosJugadoresRespondenBienNingunoGanaPuntosMCParcial(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaCorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test13AmbosJugadoresRespondenMalSiguenConCeroPuntosMCParcial(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test14AlIntentarAplicarExclusividadEnUnaPreguntaMCPenalizableSeContinuaSinAlterarLosResultados(){

        String enunciado = "Cuales de estos son postres?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("Tiramisú");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("Gelatina");

        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("Cordero a la Wellington");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("Carne al horno");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("Papas al horno");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta1);
        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));

        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1,jugador1.obtenerPuntos());
        assertEquals(1,jugador2.obtenerPuntos());
    }

    @Test
    public void test15UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoOrden(){

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple respuestaOrden1 = new OpcionSimple("1");
        OpcionSimple respuestaOrden2 = new OpcionSimple("2");
        OpcionSimple respuestaOrden3 = new OpcionSimple("3");
        OpcionSimple respuestaOrden4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<OpcionSimple> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<OpcionSimple> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(respuestasJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1OC,respuestasJugador2OC);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test16SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntosOrden(){

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple respuestaOrden1 = new OpcionSimple("1");
        OpcionSimple respuestaOrden2 = new OpcionSimple("2");
        OpcionSimple respuestaOrden3 = new OpcionSimple("3");
        OpcionSimple respuestaOrden4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<OpcionSimple> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<OpcionSimple> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(respuestasJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));


        jugada.procesarJugada(respuestasJugador1OC,respuestasJugador2OC);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test17AmbosJugadoresRespondenBienNingunoGanaPuntosOrden(){

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple respuestaOrden1 = new OpcionSimple("1");
        OpcionSimple respuestaOrden2 = new OpcionSimple("2");
        OpcionSimple respuestaOrden3 = new OpcionSimple("3");
        OpcionSimple respuestaOrden4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<OpcionSimple> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<OpcionSimple> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden3);
        respuestasJugador2.add(respuestaOrden4);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(respuestasJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1OC,respuestasJugador2OC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test18AmbosJugadoresRespondenMalSiguenConCeroPuntosOrden(){

        String enunciado = "Ordenar de menor a mayor";


        OpcionSimple respuestaOrden1 = new OpcionSimple("1");
        OpcionSimple respuestaOrden2 = new OpcionSimple("2");
        OpcionSimple respuestaOrden3 = new OpcionSimple("3");
        OpcionSimple respuestaOrden4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<OpcionSimple> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<OpcionSimple> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(respuestasJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(respuestasJugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1OC,respuestasJugador2OC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test19UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoGrupo(){

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        OpcionSimple respuesta1Grupo1 = new OpcionSimple("Java");
        OpcionSimple respuesta2Grupo1 = new OpcionSimple("C#");
        OpcionSimple respuesta3Grupo1 = new OpcionSimple("C++");
        OpcionSimple respuesta1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple respuesta2Grupo2 = new OpcionSimple("Python");
        OpcionSimple respuesta3Grupo2 = new OpcionSimple("Javascript");


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, "Tipado estatico", grupo1Respuesta,"Tipado dinamico", grupo2Respuesta);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo2);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo1);


        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador1,"Tipado dinamico", respuestaGrupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador2,"Tipado dinamico", respuestaGrupo2Jugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));

        jugada.procesarJugada(respuestasJugador1GC,respuestasJugador2GC);

        assertEquals(2,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }


    @Test
    public void test20SeUsanDosExclusividadesUnSoloJugadorRespondeBienYCuadriplicaPuntosGrupo(){

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";


        OpcionSimple respuesta1Grupo1 = new OpcionSimple("Java");
        OpcionSimple respuesta2Grupo1 = new OpcionSimple("C#");
        OpcionSimple respuesta3Grupo1 = new OpcionSimple("C++");
        OpcionSimple respuesta1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple respuesta2Grupo2 = new OpcionSimple("Python");
        OpcionSimple respuesta3Grupo2 = new OpcionSimple("Javascript");


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, "Tipado estatico", grupo1Respuesta, "Tipado dinamico", grupo2Respuesta);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo2);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo1);

        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador1,"Tipado dinamico", respuestaGrupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador2,"Tipado dinamico", respuestaGrupo2Jugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));
        jugada.procesarJugada(respuestasJugador1GC,respuestasJugador2GC);

        assertEquals(4,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test21AmbosJugadoresRespondenBienNingunoGanaPuntosGrupo(){

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";


        OpcionSimple respuesta1Grupo1 = new OpcionSimple("Java");
        OpcionSimple respuesta2Grupo1 = new OpcionSimple("C#");
        OpcionSimple respuesta3Grupo1 = new OpcionSimple("C++");
        OpcionSimple respuesta1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple respuesta2Grupo2 = new OpcionSimple("Python");
        OpcionSimple respuesta3Grupo2 = new OpcionSimple("Javascript");


        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado,"Tipado estatico", grupo1Respuesta, "Tipado dinamico", grupo2Respuesta);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo1);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo2);


        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador1,"Tipado dinamico", respuestaGrupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador2,"Tipado dinamico", respuestaGrupo2Jugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));
        jugada.procesarJugada(respuestasJugador1GC,respuestasJugador2GC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

    @Test
    public void test22AmbosJugadoresRespondenMalSiguenConCeroPuntosGrupo(){

        String enunciado = "Agrupar lenguaje segun tipado estatico y dinamico";

        OpcionSimple respuesta1Grupo1 = new OpcionSimple("Java");
        OpcionSimple respuesta2Grupo1 = new OpcionSimple("C#");
        OpcionSimple respuesta3Grupo1 = new OpcionSimple("C++");
        OpcionSimple respuesta1Grupo2 = new OpcionSimple("PHP");
        OpcionSimple respuesta2Grupo2 = new OpcionSimple("Python");
        OpcionSimple respuesta3Grupo2 = new OpcionSimple("Javascript");

        ArrayList<OpcionSimple> grupo1Respuesta = new ArrayList<>();
        ArrayList<OpcionSimple> grupo2Respuesta = new ArrayList<>();

        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo2);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo1);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado,"Tipado estatico", grupo1Respuesta,"Tipado dinamico", grupo2Respuesta);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo2);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo1);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<OpcionSimple> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<OpcionSimple> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo1);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo2);


        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador1,"Tipado dinamico", respuestaGrupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice("Tipado estatico", respuestaGrupo1Jugador2,"Tipado dinamico", respuestaGrupo2Jugador2);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        jugada.agregarModificador(new Exclusividad(jugador1));
        jugada.agregarModificador(new Exclusividad(jugador2));
        jugada.procesarJugada(respuestasJugador1GC,respuestasJugador2GC);

        assertEquals(0,jugador1.obtenerPuntos());
        assertEquals(0,jugador2.obtenerPuntos());
    }

}
