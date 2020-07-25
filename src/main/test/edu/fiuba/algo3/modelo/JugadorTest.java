package edu.fiuba.algo3.modelo;

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
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Diciembre tiene 31 dias?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();


        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoClasico);

        Jugador jugador = new Jugador("Pedro");

        RespuestaComun respuestaJugador = respuestaCorrecta;
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(1, jugador.obtenerPuntos());
    }

    @Test
    public void test03UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoYNoTienePuntos() {
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoClasico);

        Jugador jugador = new Jugador("Lucas");

        RespuestaComun respuestaJugador = respuestaIncorrecta;
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(0, jugador.obtenerPuntos());

    }

    @Test
    public void test04UnJugadorResponde5PreguntasVerdaderoFalsoBienYTiene5Puntos() {
        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "El pasto es verde?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoClasico);

        Jugador jugador = new Jugador("Lucas");
        RespuestaComun respuestaJugador = respuestaCorrecta;

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        //Reutilizamos la misma pregunta y el jugador las responde varias veces para simular que responde muchas preguntas
        for(int i = 0; i < 5; i++) {
            jugador.responder(unaPregunta, respuestasJugador);
        }

        assertEquals(5, jugador.obtenerPuntos());

    }

    @Test
    public void test05UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoPenalizableYTienePuntosNegativos() {
        TipoPuntajePenalizable tipoPenalizable = new TipoPuntajePenalizable();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Existe el comando git mix?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoPenalizable);


        Jugador jugador = new Jugador("Lucas");

        RespuestaComun respuestaJugador = respuestaIncorrecta;
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(-1, jugador.obtenerPuntos());

    }

    @Test
    public void test06UnJugadorRespondeCorrectamenteUnaPreguntaVerdaderoFalsoPenalizableYSumaPuntos() {
        TipoPuntajePenalizable tipoPenalizable = new TipoPuntajePenalizable();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Existe el comando git mix?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Falso");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Verdadero");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoPenalizable);


        Jugador jugador = new Jugador("Lucas");

        RespuestaComun respuestaJugador = respuestaCorrecta;
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaJugador);

        jugador.responder(unaPregunta, respuestasJugador);

        assertEquals(1, jugador.obtenerPuntos());

    }

    @Test
    public void test07UnJugadorRespondeVariasPreguntasVFPenalizablesYLeQuedan0Puntos() {
        TipoPuntajePenalizable tipoPenalizable = new TipoPuntajePenalizable();
        MetodoVerdaderoFalso verdaderoFalso = new MetodoVerdaderoFalso();
        String enunciado = "Todo metodo iterativo se puede hacer recursivo?";

        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Verdadero");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Falso");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);
        respuestasIncorrectas.add(respuestaIncorrecta);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, verdaderoFalso, tipoPenalizable);

        Jugador jugador = new Jugador("Lucas");
        RespuestaComun respuestaCorrectaJugador = respuestaCorrecta;
        RespuestaComun respuestaIncorrectaJugador = respuestaIncorrecta;

        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeClasico  puntaje = new TipoPuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("FFFX");
        RespuestaIncorrecta respuestaIncorrecta3 = new RespuestaIncorrecta("CSS");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeClasico  puntaje = new TipoPuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
            ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

            TipoPuntajeClasico  puntaje = new TipoPuntajeClasico();
            MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
            String enunciado = "Cuales de estos son lenguajes de programacion?";

            RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
            RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
            RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

            ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
            ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeParcial puntaje = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Python");
        RespuestaCorrecta respuestaCorrecta4 = new RespuestaCorrecta("C++");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeParcial puntaje = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Python");
        RespuestaCorrecta respuestaCorrecta4 = new RespuestaCorrecta("C++");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeParcial puntaje = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajeParcial  puntaje = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("C#");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("PHP");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("HTML");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Gato");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Delfin");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Mapache");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Tiburon");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Iguana");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Gato");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Delfin");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Mapache");
        RespuestaCorrecta respuestaCorrecta4 = new RespuestaCorrecta("Gorila");
        RespuestaIncorrecta respuestaIncorrecta = new RespuestaIncorrecta("Iguana");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Gato");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Delfin");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Iguana");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Cocodrilo");
        RespuestaIncorrecta respuestaIncorrecta3 = new RespuestaIncorrecta("Sanguijuela");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son mamiferos?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Gato");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Delfin");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Iguana");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Cocodrilo");
        RespuestaIncorrecta respuestaIncorrecta3 = new RespuestaIncorrecta("Sanguijuela");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        TipoPuntajePenalizable puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son simuladores?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Santos");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Ravenna");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Lamponne");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Garponne");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Juan");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
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




}