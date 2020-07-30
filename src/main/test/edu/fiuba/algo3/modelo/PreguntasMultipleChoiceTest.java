package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Resultado;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaCorrectaMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.multipleChoice.RespuestaIncorrectaMultipleChoice;

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

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());
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

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test03IntentoCrearUnaPreguntaMultipleChoiceCon1RespuestaYLanzaExcepcion(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();
        respuestasCorrectas.add(respuestaCorrecta1);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceClasico(enunciado,respuestasCorrectas,respuestasIncorrectas);}
        );
    }

    @Test
    public void test04CreoUnaPreguntaMultipleChoiceParcialSeEligenTresCorrectasYDevuelveTresPuntos(){

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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(3,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test05CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDevuelveDosPuntos(){

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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(2,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test06CreoUnaPreguntaMultipleChoiceParcialSeEligenDosCorrectasYDosIncorrectasYNoDevuelvePuntos(){

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("CocaCola");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test07CreoUnaPreguntaMultipleChoiceParcialYSeEligen4RespuestasCorrectasYUnaIncorrectaYNoDevuelvePuntos() {


        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Flan");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("Helado");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoiceParcial(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaCorrecta4);
        respuestasJugador.add(respuestaIncorrecta1);


        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test08CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasYDevuelve3Puntos() {

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Flan");
        RespuestaCorrectaMultipleChoice respuestaCorrecta4 = new RespuestaCorrectaMultipleChoice("Helado");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasCorrectas.add(respuestaCorrecta4);
        respuestasIncorrectas.add(respuestaIncorrecta1);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(3,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test09CreoUnaPreguntaMultipleChoicePenalizableYSeEligenRespuestas2IncorrectasYDevuelve2PuntosNegativos() {

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Flan");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(-2,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test10CreoUnaPreguntaMultipleChoicePenalizableYSeEligen3RespuestasCorrectasY2IncorrectaYDevuelve1Punto() {

        String enunciado = "Cuales de estos son postres?";

        RespuestaCorrectaMultipleChoice respuestaCorrecta1 = new RespuestaCorrectaMultipleChoice("Tiramisú");
        RespuestaCorrectaMultipleChoice respuestaCorrecta2 = new RespuestaCorrectaMultipleChoice("Gelatina");
        RespuestaCorrectaMultipleChoice respuestaCorrecta3 = new RespuestaCorrectaMultipleChoice("Flan");

        RespuestaIncorrectaMultipleChoice respuestaIncorrecta1 = new RespuestaIncorrectaMultipleChoice("Cordero a la Wellington");
        RespuestaIncorrectaMultipleChoice respuestaIncorrecta2 = new RespuestaIncorrectaMultipleChoice("Carne al horno");

        ArrayList<RespuestaCorrectaMultipleChoice> respuestasCorrectas = new ArrayList<>();
        ArrayList<RespuestaIncorrectaMultipleChoice> respuestasIncorrectas = new ArrayList<>();

        respuestasCorrectas.add(respuestaCorrecta1);
        respuestasCorrectas.add(respuestaCorrecta2);
        respuestasCorrectas.add(respuestaCorrecta3);
        respuestasIncorrectas.add(respuestaIncorrecta1);
        respuestasIncorrectas.add(respuestaIncorrecta2);

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaCorrecta3);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);


        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test11CreoUnaPreguntaMultipleChoicePenalizableYSeEligen2RespuestasCorrectasY3IncorrectasYDevuelve1PuntoNegativo() {

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

        Pregunta preguntaMultipleChoice = FabricaDePreguntas.CrearMultipleChoicePenalizable(enunciado,respuestasCorrectas,respuestasIncorrectas);
        ArrayList<Respuesta> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaCorrecta1);
        respuestasJugador.add(respuestaCorrecta2);
        respuestasJugador.add(respuestaIncorrecta1);
        respuestasJugador.add(respuestaIncorrecta2);
        respuestasJugador.add(respuestaIncorrecta3);

        Resultado resultado = preguntaMultipleChoice.evaluar(respuestasJugador);

        assertEquals(-1,resultado.obtenerPuntos().valorNumerico());
    }
}
