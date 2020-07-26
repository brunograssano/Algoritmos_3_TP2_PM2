package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private MetodoRespuesta metodo;
    private Puntaje puntaje;

    public Pregunta(String enunciado, ArrayList<RespuestaCorrecta> respuestasCorrectas,ArrayList<RespuestaIncorrecta> respuestasIncorrectas, MetodoRespuesta unMetodo, Puntaje unTipoPuntos) {

        this.enunciado = enunciado;
        this.metodo = unMetodo;
        this.puntaje = unTipoPuntos;
        this.metodo.agregarRespuestas(respuestasCorrectas,respuestasIncorrectas);

    }

    public int responder(ArrayList<RespuestaComun> respuestas) {
        //return tipoPuntaje.evaluar(metodo,respuestas);
        Resultado unResultado = metodo.evaluar(respuestas);
        return puntaje.evaluar(unResultado);
    }
}
