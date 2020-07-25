package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PreguntasMultipleChoiceTest {

    @Test
    public void test01CreoUnaPreguntaMultipleChoiceClasicoSeEligenLasCorrectasYDevuelveUnPunto(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Vigilante");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, multipleChoice,tipoClasico);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(1,puntos);
    }

    @Test
    public void test02CreoUnaPreguntaMultipleChoiceClasicoYSeEligenLasIncorrectasYNoDevuelvePuntos(){

        TipoPuntajeClasico tipoClasico = new TipoPuntajeClasico();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Vigilante");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,tipoClasico);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaIncorrecta1);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(0,puntos);
    }
    @Test
    public void test03IntentoCrearUnaPreguntaMultipleChoiceCon1RespuestaYLanzaExcepcion(){

        TipoPuntajeParcial tipoParcial = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Esta pregunta es una prueba?";
        RespuestaCorrecta respuestaCorrecta = new RespuestaCorrecta("Nah");
        
        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta);


        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta unaPregunta = new Pregunta(enunciado, respuestasCorrectas, respuestasIncorrectas, multipleChoice ,tipoParcial);}
        );
    }

    @Test
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenTresCorrectasYDevuelveTresPuntos(){

        TipoPuntajeParcial tipoParcial = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Vigilante");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,tipoParcial);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(3,puntos);
    }
    @Test
    public void test05CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDevuelveDosPuntos(){

        TipoPuntajeParcial tipoParcial = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Vigilante");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,tipoParcial);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(2,puntos);
    }
    @Test
    public void test06CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDosIncorrectasYNoDevuelvePuntos(){

        TipoPuntajeParcial tipoParcial = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Tiramisú");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Gelatina");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Cordero a la Wellington");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Coca Cola");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,tipoParcial);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(0,puntos);
    }

    @Test
    public void test07CreoUnaPreguntaMultipleChoiceParcialYSeEligen4RespuestasCorrectasYUnaIncorrectaYNoDevuelvePuntos() {

        TipoPuntajeParcial tipoParcial = new TipoPuntajeParcial();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son pokemones?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Pikachu");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Giratina");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Charizard");
        RespuestaCorrecta respuestaCorrecta4 = new RespuestaCorrecta("Entei");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Gelatina");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,tipoParcial);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
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

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Milka");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Cardbury");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Block");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(3,puntos);
    }

    @Test
    public void test09CreoUnaPreguntaMultipleChoicePenalizableYSeEligenRespuestas2IncorrectasYDevuelve2PuntosNegativos() {

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Doritos");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Broccoli");
        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Milka");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(-2,puntos);
    }

    @Test
    public void test10CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasY2IncorrectaYDevuelve1Punto() {

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
        MetodoMultipleChoice multipleChoice = new MetodoMultipleChoice();
        String enunciado = "Cuales de estos son chocolates?";

        RespuestaCorrecta respuestaCorrecta1 = new RespuestaCorrecta("Milka");
        RespuestaCorrecta respuestaCorrecta2 = new RespuestaCorrecta("Block");
        RespuestaCorrecta respuestaCorrecta3 = new RespuestaCorrecta("Shot");
        RespuestaIncorrecta respuestaIncorrecta1 = new RespuestaIncorrecta("Doritos");
        RespuestaIncorrecta respuestaIncorrecta2 = new RespuestaIncorrecta("Broccoli");

        ArrayList<RespuestaCorrecta> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrecta> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta unaPregunta = new Pregunta(enunciado,respuestasCorrectas,respuestasIncorrectas,multipleChoice,puntaje);
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

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

        TipoPuntajePenalizable  puntaje = new TipoPuntajePenalizable();
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
        ArrayList<RespuestaComun> respuestasJugador = new ArrayList<>();

        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        int puntos = unaPregunta.responder(respuestasJugador);

        assertEquals(-1,puntos);
    }
}
