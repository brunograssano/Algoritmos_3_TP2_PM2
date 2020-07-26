package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;

import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasMultipleChoiceTest {

    @Test
    public void test01CreoUnaPreguntaMultipleChoiceClasicoSeEligenLasCorrectasYDevuelveUnPunto(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Vigilante");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(1,resultado.obtenerPuntos());
    }

    @Test
    public void test02CreoUnaPreguntaMultipleChoiceClasicoYSeEligenLasIncorrectasYNoDevuelvePuntos(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Vigilante");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaCorrecta3);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(0,resultado.obtenerPuntos());
    }
    /*
    @Test
    public void test03IntentoCrearUnaPreguntaMultipleChoiceCon1RespuestaYLanzaExcepcion(){

        PuntajeParcial puntajeParcial = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Esta pregunta es una prueba?";
        RespuestaCorrectaMultipleChoice respuestaCorrecta = new RespuestaCorrectaMultipleChoice("Nah");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);


        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, multipleChoice ,puntajeParcial);}
        );
    }

    @Test
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenTresCorrectasYDevuelveTresPuntos(){

        PuntajeParcial puntajeParcial = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Vigilante");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajeParcial);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(3,puntos);
    }
    @Test
    public void test05CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDevuelveDosPuntos(){

        PuntajeParcial puntajeParcial = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Vigilante");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajeParcial);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(2,puntos);
    }
    @Test
    public void test06CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDosIncorrectasYNoDevuelvePuntos(){

        PuntajeParcial puntajeParcial = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Coca Cola");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajeParcial);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(0,puntos);
    }

    @Test
    public void test07CreoUnaPreguntaMultipleChoiceParcialYSeEligen4RespuestasCorrectasYUnaIncorrectaYNoDevuelvePuntos() {

        PuntajeParcial puntajeParcial = new PuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son pokemones?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Pikachu");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Giratina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Charizard");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("Entei");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Gelatina");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajeParcial);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaCorrecta4);
        respuestasJugador.add(respuestaIncorrecta1);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(0,puntos);
    }

    @Test
    public void test08CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasYDevuelve3Puntos() {

        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Milka");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Cardbury");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Block");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajePenalizable);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(3,puntos);
    }

    @Test
    public void test09CreoUnaPreguntaMultipleChoicePenalizableYSeEligenRespuestas2IncorrectasYDevuelve2PuntosNegativos() {

        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Doritos");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Broccoli");
        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Milka");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajePenalizable);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(-2,puntos);
    }

    @Test
    public void test10CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasY2IncorrectaYDevuelve1Punto() {

        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Milka");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Block");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Shot");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Doritos");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Broccoli");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajePenalizable);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);
    }
    @Test
    public void test11CreoUnaPreguntaMultipleChoicePenalizableYSeEligen2RespuestasCorrectasY3IncorrectasYDevuelve1PuntoNegativo() {

        PuntajePenalizable puntajePenalizable = new PuntajePenalizable();
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

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntajePenalizable);
        ArrayList<RespuestaMultipleChoice> respuestasJugador = new ArrayList<>();

        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(-1,puntos);
    }*/
}
