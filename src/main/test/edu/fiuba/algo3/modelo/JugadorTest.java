package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionCorrectaVerdaderoFalso;
import edu.fiuba.algo3.modelo.preguntas.opciones.evaluables.OpcionIncorrectaVerdaderoFalso;
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

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test03UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoYNoTienePuntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        OpcionIncorrectaVerdaderoFalso respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = respuestaIncorrecta;
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = respuestaIncorrecta;

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(0, jugador1.obtenerPuntos());

    }

    @Test
    public void test04UnJugadorResponde5PreguntasVerdaderoFalsoClasicoBienYTiene5Puntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        OpcionCorrectaVerdaderoFalso respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoClasico(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);
        for(int i = 0; i < 5; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }

        assertEquals(5, jugador1.obtenerPuntos());

    }
    @Test
    public void test05UnJugadorRespondeErroneamenteUnaPreguntaVerdaderoFalsoPenalizableYTienePuntosNegativos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        OpcionIncorrectaVerdaderoFalso respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        OpcionIncorrectaVerdaderoFalso respuestaJugador1 = respuestaIncorrecta;
        OpcionIncorrectaVerdaderoFalso respuestaJugador2 = respuestaIncorrecta;

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(-1, jugador1.obtenerPuntos());

    }
    @Test
    public void test06UnJugadorRespondeCorrectamenteUnaPreguntaVerdaderoFalsoPenalizableYSumaPuntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        OpcionCorrectaVerdaderoFalso respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);

        jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);

        assertEquals(1, jugador1.obtenerPuntos());

    }

    @Test
    public void test07UnJugadorRespondeVariasPreguntasVFPenalizablesYLeQuedan0Puntos() {
        String enunciado = "El pasto es verde?";
        boolean enunciadoEsCorrecto = true;

        OpcionCorrectaVerdaderoFalso respuestaCorrecta = new OpcionCorrectaVerdaderoFalso(enunciadoEsCorrecto);

        Pregunta preguntaVerdaderoFalso = FabricaDePreguntas.CrearVerdaderoFalsoPenalizable(enunciado,enunciadoEsCorrecto);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaVerdaderoFalso);

        OpcionCorrectaVerdaderoFalso respuestaJugador1 = respuestaCorrecta;
        OpcionCorrectaVerdaderoFalso respuestaJugador2 = respuestaCorrecta;

        RespuestaVerdaderoFalso respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaJugador1);
        RespuestaVerdaderoFalso respuestasJugador2VoF = new RespuestaVerdaderoFalso(respuestaJugador2);
        for(int i = 0; i < 3; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }
        OpcionIncorrectaVerdaderoFalso respuestaIncorrecta = new OpcionIncorrectaVerdaderoFalso(!enunciadoEsCorrecto);
        OpcionIncorrectaVerdaderoFalso respuestaIncorrectaJugador1 = respuestaIncorrecta;
        respuestasJugador1VoF = new RespuestaVerdaderoFalso(respuestaIncorrectaJugador1);
        for(int i = 0; i < 3; i++){
            jugada.procesarJugada(respuestasJugador1VoF,respuestasJugador2VoF);
        }

        assertEquals(0, jugador1.obtenerPuntos());

    }

    @Test
    public void test08UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYSuma1Punto() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("HTML");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("FFFX");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test09UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoIncorrectamenteYSuma0Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("HTML");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("FFFX");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta2);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0, jugador1.obtenerPuntos());
    }

    @Test
    public void test10UnJugadorRespondeUnaPreguntaMultipleChoiceClasicoCorrectamenteYUnaIncorectamenteYSuma1Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("HTML");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("FFFX");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        respuestasJugador1.add(respuestaIncorrecta1);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test11UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon4RespuestasCorrectasY0IncorrectasYSuma4Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);



        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);
        respuestasJugador1.add(respuestaCorrecta4);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(4, jugador1.obtenerPuntos());
    }
    @Test
    public void test12UnJugadorRespondeUnaPreguntaMultipleChoiceParcialCon1RespuestaCorrectaY0IncorrectasYSuma1Punto() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);



        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(1, jugador1.obtenerPuntos());
    }

    @Test
    public void test13UnJugadoRespondeUnaPreguntaMultipleChoiceParcialCon2RespuestasCorrectasY1IncorrectaYSuma0Puntos(){
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta1);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(0, jugador1.obtenerPuntos());
    }
    @Test
    public void test14UnJugadoRespondeVariasPreguntasMultipleChoiceParcialYTieneElNumeroCorrectoDePuntos(){

        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
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

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(3, jugador1.obtenerPuntos());
    }
    @Test
    public void test16UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon4RespuestasCorrectasY1IncorrectaYSuma3Puntos() {
        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(3, jugador1.obtenerPuntos());
    }
    @Test
    public void test17UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon2RespuestasCorrectasY3IncorrectasYResta1Punto() {

        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("HTML");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("JSON");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);
        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador1.add(respuestaIncorrecta2);
        respuestasJugador1.add(respuestaIncorrecta3);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(-1, jugador1.obtenerPuntos());
    }
    @Test
    public void test18UnJugadorRespondeUnaPreguntaMultipleChoicePenalizableCon3RespuestasIncorrectasYResta3Puntos() {


        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("HTML");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta2 = new OpcionIncorrectaMultipleChoice("JSON");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta3 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta3);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();

        respuestasJugador1.add(respuestaIncorrecta1);
        respuestasJugador1.add(respuestaIncorrecta2);
        respuestasJugador1.add(respuestaIncorrecta3);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);
        jugada.procesarJugada(respuestasJugador1MC,respuestasJugador2MC);

        assertEquals(-3, jugador1.obtenerPuntos());
    }

    @Test
    public void test19UnJugadorRespondeVariasPreguntasMultipleChoicePenalizablesYTieneElNumeroCorrectoDePuntos() {


        String enunciado = "Cuales de estos son lenguajes de programacion?";

        OpcionCorrectaMultipleChoice respuestaCorrecta1 = new OpcionCorrectaMultipleChoice("C#");
        OpcionCorrectaMultipleChoice respuestaCorrecta2 = new OpcionCorrectaMultipleChoice("PHP");
        OpcionCorrectaMultipleChoice respuestaCorrecta3 = new OpcionCorrectaMultipleChoice("C");
        OpcionCorrectaMultipleChoice respuestaCorrecta4 = new OpcionCorrectaMultipleChoice("C++");
        OpcionIncorrectaMultipleChoice respuestaIncorrecta1 = new OpcionIncorrectaMultipleChoice("CSS");

        ArrayList<OpcionCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<OpcionIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);

        Jugador jugador1 = new Jugador("Lucas");
        Jugador jugador2 = new Jugador("Gonzalo");

        ArrayList<OpcionEvaluable> respuestasJugador1 = new ArrayList<>();
        respuestasJugador1.add(respuestaCorrecta1);
        respuestasJugador1.add(respuestaCorrecta2);

        ArrayList<OpcionEvaluable> respuestasJugador2 = new ArrayList<>();
        respuestasJugador2.add(respuestaCorrecta1);

        Jugada jugada = new Jugada(jugador1,jugador2,preguntaMultipleChoice);

        RespuestaMultipleChoice respuestasJugador1MC = new RespuestaMultipleChoice(respuestasJugador1);
        RespuestaMultipleChoice respuestasJugador2MC = new RespuestaMultipleChoice(respuestasJugador2);


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