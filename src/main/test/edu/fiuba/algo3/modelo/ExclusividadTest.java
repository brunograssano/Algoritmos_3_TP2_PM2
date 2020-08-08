package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.modificadores.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaVerdaderoFalso;
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
    public void test05AlIntentarAplicarExclusividadEnUnaPreguntaVoFPenalizableSeDebeLanzarExcepcion(){

        String enunciado = "Slack acepta videollamadas";

        boolean respuestaALaPreguntaVoF = false;

        Pregunta pregunta = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado, respuestaALaPreguntaVoF);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);


        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{jugada.agregarModificador(new Exclusividad(jugador1));}
        );
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
    public void test14AlIntentarAplicarExclusividadEnUnaPreguntaMCPenalizableSeDebeLanzarExcepcion(){

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

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{jugada.agregarModificador(new Exclusividad(jugador1));}
        );
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

        Orden ordenJugador1 = new Orden(respuestasJugador1);
        Orden ordenJugador2 = new Orden(respuestasJugador2);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(ordenJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(ordenJugador2);

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

        Orden ordenJugador1 = new Orden(respuestasJugador1);
        Orden ordenJugador2 = new Orden(respuestasJugador2);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(ordenJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(ordenJugador2);

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

        Orden ordenJugador1 = new Orden(respuestasJugador1);
        Orden ordenJugador2 = new Orden(respuestasJugador2);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(ordenJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(ordenJugador2);

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

        Orden ordenJugador1 = new Orden(respuestasJugador1);
        Orden ordenJugador2 = new Orden(respuestasJugador2);

        RespuestaOrderedChoice respuestasJugador1OC = new RespuestaOrderedChoice(ordenJugador1);
        RespuestaOrderedChoice respuestasJugador2OC = new RespuestaOrderedChoice(ordenJugador2);

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

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

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

        Grupo grupo1Jugador1 = new Grupo("Tipado estatico", respuestaGrupo1Jugador1);
        Grupo grupo2Jugador1 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador1);
        Grupo grupo1Jugador2 = new Grupo("Tipado estatico", respuestaGrupo1Jugador2);
        Grupo grupo2Jugador2 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador2);

        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice(grupo1Jugador1, grupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice(grupo1Jugador2, grupo2Jugador2);

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

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

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

        Grupo grupo1Jugador1 = new Grupo("Tipado estatico", respuestaGrupo1Jugador1);
        Grupo grupo2Jugador1 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador1);
        Grupo grupo1Jugador2 = new Grupo("Tipado estatico", respuestaGrupo1Jugador2);
        Grupo grupo2Jugador2 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador2);

        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice(grupo1Jugador1, grupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice(grupo1Jugador2, grupo2Jugador2);

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

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

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

        Grupo grupo1Jugador1 = new Grupo("Tipado estatico", respuestaGrupo1Jugador1);
        Grupo grupo2Jugador1 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador1);
        Grupo grupo1Jugador2 = new Grupo("Tipado estatico", respuestaGrupo1Jugador2);
        Grupo grupo2Jugador2 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador2);

        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice(grupo1Jugador1, grupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice(grupo1Jugador2, grupo2Jugador2);

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

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

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

        Grupo grupo1Jugador1 = new Grupo("Tipado estatico", respuestaGrupo1Jugador1);
        Grupo grupo2Jugador1 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador1);
        Grupo grupo1Jugador2 = new Grupo("Tipado estatico", respuestaGrupo1Jugador2);
        Grupo grupo2Jugador2 = new Grupo("Tipado dinamico", respuestaGrupo2Jugador2);

        RespuestaGroupChoice respuestasJugador1GC = new RespuestaGroupChoice(grupo1Jugador1, grupo2Jugador1);
        RespuestaGroupChoice respuestasJugador2GC = new RespuestaGroupChoice(grupo1Jugador2, grupo2Jugador2);

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
