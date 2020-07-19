package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pregunta {

    private String enunciado;
    private MetodoRespuesta metodo;
    private TipoPuntaje tipoPuntaje;

    public Pregunta(String enunciado, ArrayList<Respuesta> respuestas, MetodoRespuesta unMetodo, TipoPuntaje unTipoPuntos) {

        this.enunciado = enunciado;
        this.metodo = unMetodo;
        this.tipoPuntaje = unTipoPuntos;

        this.metodo.agregarRespuestas(respuestas);

    }

    public int responder(ArrayList<Respuesta> respuestas) {
        return metodo.evaluar(respuestas);

    }
}
