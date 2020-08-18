package edu.fiuba.algo3.modelo.preguntas;

public class OpcionSimple{

    private String enunciado;

    public OpcionSimple(String unEnunciado){
        enunciado = unEnunciado;
    }

    public String obtenerTexto() {
        return enunciado;
    }
}
