package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaExcepcion;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.RespuestaGrupal;
import edu.fiuba.algo3.modelo.preguntas.RespuestaIndividual;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.groupChoice.RespuestaGrupo;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Exclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
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

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

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
        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        jugada.agregarModificador(new Exclusividad(jugador2));
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

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

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = new RespuestaCorrectaVerdaderoFalso(respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

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

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!respuestaALaPreguntaVoF);

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

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


        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Exclusividad(jugador1));}
        );
    }


    @Test
    public void test06UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoMCClasico(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaCorrecta2);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador2.add(respuestaCorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<RespuestaIndividual> respuestasJugador1 = new ArrayList<>();
        ArrayList<RespuestaIndividual> respuestasJugador2 = new ArrayList<>();
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador2.add(respuestaIncorrecta1);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);

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

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Papas al horno");


        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta pregunta = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Joaquin");
        Jugador jugador2 = new Jugador("Bruno");

        Jugada jugada = new Jugada(jugador1, jugador2, pregunta);

        assertThrows(ModificadorNoAptoParaPreguntaExcepcion.class,
                ()->{jugada.agregarModificador(new Exclusividad(jugador1));}
        );
    }

    @Test
    public void test15UnJugadorAplicaExclusividadRespondeCorrectamenteYOtroJugadorRespondeErroneamenteSeMultiplicanPuntosAlCorrectoOrden(){

        String enunciado = "Ordenar de menor a mayor";

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<RespuestaGrupal> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaJugadorOrderedChoice respuestasJugador1OC = new RespuestaJugadorOrderedChoice(respuestasJugador1);
        RespuestaJugadorOrderedChoice respuestasJugador2OC = new RespuestaJugadorOrderedChoice(respuestasJugador2);

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

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<RespuestaGrupal> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaJugadorOrderedChoice respuestasJugador1OC = new RespuestaJugadorOrderedChoice(respuestasJugador1);
        RespuestaJugadorOrderedChoice respuestasJugador2OC = new RespuestaJugadorOrderedChoice(respuestasJugador2);

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

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<RespuestaGrupal> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden3);
        respuestasJugador2.add(respuestaOrden4);

        RespuestaJugadorOrderedChoice respuestasJugador1OC = new RespuestaJugadorOrderedChoice(respuestasJugador1);
        RespuestaJugadorOrderedChoice respuestasJugador2OC = new RespuestaJugadorOrderedChoice(respuestasJugador2);

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

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();

        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta pregunta = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaOrden3);
        respuestasJugador1.add(respuestaOrden2);
        respuestasJugador1.add(respuestaOrden1);
        respuestasJugador1.add(respuestaOrden4);

        ArrayList<RespuestaGrupal> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaOrden1);
        respuestasJugador2.add(respuestaOrden2);
        respuestasJugador2.add(respuestaOrden4);
        respuestasJugador2.add(respuestaOrden3);

        RespuestaJugadorOrderedChoice respuestasJugador1OC = new RespuestaJugadorOrderedChoice(respuestasJugador1);
        RespuestaJugadorOrderedChoice respuestasJugador2OC = new RespuestaJugadorOrderedChoice(respuestasJugador2);

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

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo2);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo1);

        RespuestaJugadorGroupChoice respuestasJugador1GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador1, respuestaGrupo2Jugador1);
        RespuestaJugadorGroupChoice respuestasJugador2GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador2, respuestaGrupo2Jugador2);

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

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo2);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo1);

        RespuestaJugadorGroupChoice respuestasJugador1GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador1, respuestaGrupo2Jugador1);
        RespuestaJugadorGroupChoice respuestasJugador2GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador2, respuestaGrupo2Jugador2);

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

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo1);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo2);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo1);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo2);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo1);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador1GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador1, respuestaGrupo2Jugador1);
        RespuestaJugadorGroupChoice respuestasJugador2GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador2, respuestaGrupo2Jugador2);

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

        RespuestaGrupo respuesta1Grupo1 = new RespuestaGrupo("Java");
        RespuestaGrupo respuesta2Grupo1 = new RespuestaGrupo("C#");
        RespuestaGrupo respuesta3Grupo1 = new RespuestaGrupo("C++");
        RespuestaGrupo respuesta1Grupo2 = new RespuestaGrupo("PHP");
        RespuestaGrupo respuesta2Grupo2 = new RespuestaGrupo("Python");
        RespuestaGrupo respuesta3Grupo2 = new RespuestaGrupo("Javascript");


        ArrayList<RespuestaGrupo> grupo1Respuesta = new ArrayList<>();
        ArrayList<RespuestaGrupo> grupo2Respuesta = new ArrayList<>();


        grupo1Respuesta.add(respuesta1Grupo1);
        grupo1Respuesta.add(respuesta2Grupo1);
        grupo1Respuesta.add(respuesta3Grupo2);
        grupo2Respuesta.add(respuesta1Grupo2);
        grupo2Respuesta.add(respuesta2Grupo2);
        grupo2Respuesta.add(respuesta3Grupo1);

        Grupo grupo1 = new Grupo("Tipado estatico",grupo1Respuesta);
        Grupo grupo2 = new Grupo("Tipado dinamico",grupo2Respuesta);

        Pregunta pregunta = FabricaDePreguntas.CrearGrupo(enunciado, grupo1, grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador1 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador1 = new ArrayList<>();

        respuestaGrupo1Jugador1.add(respuesta1Grupo1);
        respuestaGrupo1Jugador1.add(respuesta2Grupo2);
        respuestaGrupo1Jugador1.add(respuesta3Grupo1);
        respuestaGrupo2Jugador1.add(respuesta1Grupo2);
        respuestaGrupo2Jugador1.add(respuesta2Grupo1);
        respuestaGrupo2Jugador1.add(respuesta3Grupo2);

        ArrayList<RespuestaGrupal> respuestaGrupo1Jugador2 = new ArrayList<>();
        ArrayList<RespuestaGrupal> respuestaGrupo2Jugador2 = new ArrayList<>();

        respuestaGrupo1Jugador2.add(respuesta1Grupo1);
        respuestaGrupo1Jugador2.add(respuesta2Grupo1);
        respuestaGrupo1Jugador2.add(respuesta3Grupo1);
        respuestaGrupo2Jugador2.add(respuesta1Grupo2);
        respuestaGrupo2Jugador2.add(respuesta2Grupo2);
        respuestaGrupo2Jugador2.add(respuesta3Grupo2);

        RespuestaJugadorGroupChoice respuestasJugador1GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador1, respuestaGrupo2Jugador1);
        RespuestaJugadorGroupChoice respuestasJugador2GC = new RespuestaJugadorGroupChoice(respuestaGrupo1Jugador2, respuestaGrupo2Jugador2);

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
