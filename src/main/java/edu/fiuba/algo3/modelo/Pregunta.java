package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {

    private String enunciado;
    private MetodoRespuesta metodo;
    private TipoPuntaje tipoPuntaje;

    public Pregunta(String enunciado, ArrayList<RespuestaComun> respuestas, MetodoRespuesta unMetodo, TipoPuntaje unTipoPuntos) {

        this.enunciado = enunciado;
        this.metodo = unMetodo;

        this.tipoPuntaje = unTipoPuntos;
        this.metodo.agregarRespuestas(respuestas);

    }

    public int responder(ArrayList<RespuestaComun> respuestas) {
        return tipoPuntaje.evaluar(metodo,respuestas);

    }
}
