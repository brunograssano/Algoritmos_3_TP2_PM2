package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.RespuestaIncorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.verdaderoFalso.VerdaderoFalso;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class JugadorTest {

    @Test
    public void test01CreoUnJugadorYLePidoSusPuntosDeberiaSerCero() {
        Jugador jugador = new Jugador("Pedro");
        assertEquals(0, jugador.obtenerPuntos());
    }

    @Test
    public void test02UnJugadorEsAsignadoLosPuntosAlResponderCorrectamenteUnVerdaderoFalsoClasico() {

        String enunciado = "Diciembre tiene 31 dias?";
        boolean enunciadoEsCorrecto = true;
        Pregunta verdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Pedro");
        Jugador jugador2 = new Jugador("Juan");

        Jugada jugada = new Jugada(jugador1,jugador2,verdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaJugador1);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1,respuestasJugador2);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test03UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoYNoTienePuntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        RespuestaIncorrectaVerdaderoFalso respuestaIncorrecta = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = respuestaIncorrecta;
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = respuestaIncorrecta;

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaJugador1);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1,respuestasJugador2);

        assertEquals(0, jugador1.obtenerPuntos());

    }
/*
    @Test
    public void test04UnJugadorResponde5PreguntasVerdaderoFalsoBienYTiene5Puntos() {
        PuntajeClasico puntajeClasico = new PuntajeClasico();
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta = new RespuestaCorrectaMultipleChoice("Verdadero");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta = new RespuestaIncorrectaMultipleChoice("Falso");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, puntajeClasico);

        Jugador jugador = new Jugador("Lucas");
        RespuestaMultipleChoice respuestaJugador = respuestaCorrecta;

        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        //Reutilizamos la misma pregunta y el jugador las responde varias veces para simular que responde muchas preguntas
        for(int i = 0; i < 5; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        assertEquals(5, jugador.obtenerPuntos());

    }

    @Test
    public void test05UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoPenalizableYTienePuntosNegativos() {
        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso();
        String enunciado = "Existe el comando git mix?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta = new RespuestaCorrectaMultipleChoice("Falso");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta = new RespuestaIncorrectaMultipleChoice("Verdadero");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, puntajePenalizable);


        Jugador jugador = new Jugador("Lucas");

        RespuestaMultipleChoice respuestaJugador = respuestaIncorrecta;
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(-1, jugador.obtenerPuntos());

    }

    @Test
    public void test06UnJugadorRespondeCorrectamenteUnaPreguntaVerdaderoFalsoPenalizableYSumaPuntos() {
        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso();
        String enunciado = "Existe el comando git mix?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta = new RespuestaCorrectaMultipleChoice("Falso");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta = new RespuestaIncorrectaMultipleChoice("Verdadero");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, puntajePenalizable);


        Jugador jugador = new Jugador("Lucas");

        RespuestaMultipleChoice respuestaJugador = respuestaCorrecta;
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(1, jugador.obtenerPuntos());

    }

    @Test
    public void test07UnJugadorRespondeVariasPreguntasVFPenalizablesYLeQuedan0Puntos() {
        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        VerdaderoFalso verdaderoFalso = new VerdaderoFalso();
        String enunciado = "Todo metodo iterativo se puede hacer recursivo?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta = new RespuestaCorrectaMultipleChoice("Verdadero");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta = new RespuestaIncorrectaMultipleChoice("Falso");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, puntajePenalizable);

        Jugador jugador = new Jugador("Lucas");
        RespuestaMultipleChoice respuestaCorrectaJugador = respuestaCorrecta;
        RespuestaMultipleChoice respuestaIncorrectaJugador = respuestaIncorrecta;

        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrectaJugador);

        //Reutilizamos la misma pregunta y el jugador las responde varias veces con distintas respuestas para simular que responde muchas preguntas

        for (int i = 0; i < 3; i++){
            jugador.responder(unaPregunta, respuestasJugador);
        }

        respuestasJugador.remove(respuestaCorrectaJugador);
        respuestasJugador.add(respuestaIncorrectaJugador);

        for (int i = 0; i < 3; i++){
            jugador.responder(unaPregunta, respuestasJugador);
        }

        assertEquals(0, jugador.obtenerPuntos());

    }

    @Test
    public void test08UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYSuma1Punto() {

        Jugador jugador = new Jugador("Lucas");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeClasico puntaje = new PuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("FFFX");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);


        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(1, jugador.obtenerPuntos());
    }

    @Test
    public void test09UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoIncorrectamenteYSuma0Puntos() {

        Jugador jugador = new Jugador("Lucas");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeClasico puntaje = new PuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);

        jugador.responder(unaPregunta, respuestasJugador);
        assertEquals(0, jugador.obtenerPuntos());
    }

    @Test
    public void test10UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYUnaIncorectamenteYSuma1Puntos() {

            Jugador jugador = new Jugador("Pablo");
            ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

            PuntajeClasico puntaje = new PuntajeClasico();
            MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
            String enunciado = "Cuales de estos son lenguajes de programacion?";

            RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
            RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
            RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

            ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
            ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
            respuestasCorrectas.add(respuestaCorrecta1);
            respuestasCorrectas.add(respuestaCorrecta2);
            respuestasIncorrectas.add(respuestaIncorrecta1);

            Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
            respuestasJugador.add(respuestaCorrecta1);
            respuestasJugador.add(respuestaCorrecta2);

            jugador.responder(unaPregunta, respuestasJugador);

            respuestasJugador.add(respuestaIncorrecta1);
            jugador.responder(unaPregunta, respuestasJugador);

            assertEquals(1, jugador.obtenerPuntos());
    }

    @Test
    public void test11UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon4RespuestasCorrectasY0IncorrectasYSuma4Puntos() {

        Jugador jugador = new Jugador("Pablo");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeParcial puntaje = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Python");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaCorrecta4);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(4, jugador.obtenerPuntos());
    }

    @Test
    public void test12UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon1RespuestaCorrectaY0IncorrectasYSuma1Punto() {

        Jugador jugador = new Jugador("Pablo");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeParcial puntaje = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Python");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);


        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(1, jugador.obtenerPuntos());
    }

    @Test
    public void test13UnJugadoRespondeUnaPreguntaMultipleChoiceParcialCon2RespuestasCorrectasY1IncorrectaYSuma0Puntos(){

        Jugador jugador = new Jugador("Pablo");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeParcial puntaje = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(0, jugador.obtenerPuntos());
    }

    @Test
    public void test14UnJugadoRespondeVariasPreguntasMultipleChoiceParcialYTieneElNumeroCorrectoDePuntos(){

        Jugador jugador = new Jugador("Pablo");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajeParcial puntaje = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);

        //Reutilizamos la misma pregunta y el jugador las responde varias veces con distintas respuestas para simular que responde muchas preguntas
        for (int i = 0; i < 10; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        respuestasJugador.add(respuestaIncorrecta1);

        for (int i = 0; i < 10; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        assertEquals(20, jugador.obtenerPuntos());
    }


    @Test
    public void test15UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon3RespuestasCorrectasYSuma3Puntos() {

        Jugador jugador = new Jugador("Oscar");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajePenalizable puntaje = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Gato");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Delfin");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Mapache");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Tiburon");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Iguana");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(3, jugador.obtenerPuntos());
    }

    @Test
    public void test16UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon4RespuestasCorrectasY1IncorrectaYSuma3Puntos() {

        Jugador jugador = new Jugador("ISURUS | 10429");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajePenalizable puntaje = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Gato");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Delfin");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Mapache");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("Gorila");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta = new RespuestaIncorrectaMultipleChoice("Iguana");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaCorrecta4);
        respuestasJugador.add(respuestaIncorrecta);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(3, jugador.obtenerPuntos());
    }

    @Test
    public void test17UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon2RespuestasCorrectasY3IncorrectasYResta1Punto() {

        Jugador jugador = new Jugador("ISURUS | 10429");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajePenalizable puntaje = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Gato");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Delfin");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Iguana");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Cocodrilo");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Sanguijuela");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(-1, jugador.obtenerPuntos());
    }

    @Test
    public void test18UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon3RespuestasIncorrectasYResta3Puntos() {

        Jugador jugador = new Jugador("ISURUS | 10429");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajePenalizable puntaje = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Gato");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Delfin");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Iguana");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Cocodrilo");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("Sanguijuela");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);

        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(-3, jugador.obtenerPuntos());
    }

    @Test
    public void test19UnJugadorRespondeVariasPreguntasMultipleChoicePenalizablesYTieneElNumeroCorrectoDePuntos() {

        Jugador jugador = new Jugador("Pablo");
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        PuntajePenalizable puntaje = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son simuladores?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Santos");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Ravenna");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Lamponne");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Garponne");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Juan");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);

        //Reutilizamos la misma pregunta y el jugador las responde varias veces con distintas respuestas para simular que responde muchas preguntas
        for (int i = 0; i < 3; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaCorrecta3);

        for (int i = 0; i < 5; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }
        respuestasJugador.add(respuestaIncorrecta2);
        for (int i = 0; i < 15; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        assertEquals(31, jugador.obtenerPuntos());
    }

*/


}