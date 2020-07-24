package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void test03CreoUnaPreguntaMultipleChoiceParcialSeEligenTresCorrectasYDevuelveTresPuntos(){

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
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDevuelveDosPuntos(){

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
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDosIncorrectasDevuelveDosPuntos(){

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

        assertEquals(2,puntos);
    }
}
