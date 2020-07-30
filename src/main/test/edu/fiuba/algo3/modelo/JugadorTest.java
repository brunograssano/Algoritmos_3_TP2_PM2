package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
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

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

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

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0, jugador1.obtenerPuntos());

    }

    @Test
    public void test04UnJugadorResponde5PreguntasVerdaderoFalsoClasicoBienYTiene5Puntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        RespuestaCorrectaVerdaderoFalso respuestaCorrecta = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);
        for(int i = 0; i < 5; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }

        assertEquals(5, jugador1.obtenerPuntos());

    }
    @Test
    public void test05UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoPenalizableYTienePuntosNegativos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        RespuestaIncorrectaVerdaderoFalso respuestaIncorrecta = new RespuestaIncorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        RespuestaIncorrectaVerdaderoFalso respuestaJugador1 = respuestaIncorrecta;
        RespuestaIncorrectaVerdaderoFalso respuestaJugador2 = respuestaIncorrecta;

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(-1, jugador1.obtenerPuntos());

    }
    @Test
    public void test06UnJugadorRespondeCorrectamenteUnaPreguntaVerdaderoFalsoPenalizableYSumaPuntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        RespuestaCorrectaVerdaderoFalso respuestaCorrecta = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1, jugador1.obtenerPuntos());

    }

    @Test
    public void test07UnJugadorRespondeVariasPreguntasVFPenalizablesYLeQuedan0Puntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        RespuestaCorrectaVerdaderoFalso respuestaCorrecta = new RespuestaCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        RespuestaCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        RespuestaCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaJugadorVerdaderoFalso respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador1);
        RespuestaJugadorVerdaderoFalso respuestasJugador2VoF = new RespuestaJugadorVerdaderoFalso(respuestaJugador2);
        for(int i = 0; i < 3; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }
        RespuestaIncorrectaVerdaderoFalso respuestaIncorrecta = new RespuestaIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);
        RespuestaIncorrectaVerdaderoFalso respuestaIncorrectaJugador1 = respuestaIncorrecta;
        respuestasJugador1VoF = new RespuestaJugadorVerdaderoFalso(respuestaIncorrectaJugador1);
        for(int i = 0; i < 3; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }

        assertEquals(0, jugador1.obtenerPuntos());

    }

    @Test
    public void test08UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYSuma1Punto() {
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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test09UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoIncorrectamenteYSuma0Puntos() {
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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta2);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0, jugador1.obtenerPuntos());
    }

    @Test
    public void test10UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYUnaIncorectamenteYSuma1Puntos() {
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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        respuestasJugador1.add(respuestaIncorrecta1);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test11UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon4RespuestasCorrectasY0IncorrectasYSuma4Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);



        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);
        respuestasJugador1.add(respuestaCorrecta4);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(4, jugador1.obtenerPuntos());
    }
    @Test
    public void test12UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon1RespuestaCorrectaY0IncorrectasYSuma1Punto() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);



        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test13UnJugadoRespondeUnaPreguntaMultipleChoiceParcialCon2RespuestasCorrectasY1IncorrectaYSuma0Puntos(){
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta1);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0, jugador1.obtenerPuntos());
    }
    @Test
    public void test14UnJugadoRespondeVariasPreguntasMultipleChoiceParcialYTieneElNumeroCorrectoDePuntos(){

        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        //Reutilizamos la misma pregunta y el jugador las responde varias veces con distintas respuestas para simular que responde muchas preguntas
        for (int i = 0; i < 10; i++) {
            jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);
        }
        respuestasJugador1.add(respuestaIncorrecta1);

        for (int i = 0; i < 10; i++) {
            jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);
        }

        assertEquals(20, jugador1.obtenerPuntos());
    }

    @Test
    public void test15UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon3RespuestasCorrectasYSuma3Puntos() {

        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(3, jugador1.obtenerPuntos());
    }
    @Test
    public void test16UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon4RespuestasCorrectasY1IncorrectaYSuma3Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(3, jugador1.obtenerPuntos());
    }
    @Test
    public void test17UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon2RespuestasCorrectasY3IncorrectasYResta1Punto() {

        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("JSON");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador1.add(respuestaIncorrecta2);
        respuestasJugador1.add(respuestaIncorrecta3);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(-1, jugador1.obtenerPuntos());
    }
    @Test
    public void test18UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon3RespuestasIncorrectasYResta3Puntos() {


        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("HTML");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("JSON");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta3 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();

        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador1.add(respuestaIncorrecta2);
        respuestasJugador1.add(respuestaIncorrecta3);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(-3, jugador1.obtenerPuntos());
    }

    @Test
    public void test19UnJugadorRespondeVariasPreguntasMultipleChoicePenalizablesYTieneElNumeroCorrectoDePuntos() {


        String enunciado = "Cuales de estos son lenguajes de programacion?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("C#");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("PHP");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("C");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("C++");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CSS");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<Respuesta> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<Respuesta> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaJugadorMultipleChoice respuestasJugador1MC = new RespuestaJugadorMultipleChoice(respuestasJugador1);
        RespuestaJugadorMultipleChoice respuestasJugador2MC = new RespuestaJugadorMultipleChoice(respuestasJugador2);


        //Reutilizamos la misma pregunta y el jugador las responde varias veces con distintas respuestas para simular que responde muchas preguntas
        for (int i = 0; i < 10; i++) {
            jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);
        }
        respuestasJugador1.add(respuestaIncorrecta1);

        for (int i = 0; i < 10; i++) {
            jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);
        }

        assertEquals(30, jugador1.obtenerPuntos());
    }
}