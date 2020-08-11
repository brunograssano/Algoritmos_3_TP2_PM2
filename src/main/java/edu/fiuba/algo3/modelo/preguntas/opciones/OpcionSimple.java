package edu.fiuba.algo3.modelo.preguntas.opciones;

public class OpcionSimple implements Opcion{

    private String enunciado;

    public OpcionSimple(String unEnunciado){
        enunciado = unEnunciado;
    }

    @Override
    public String obtenerTexto() {
        return enunciado;
    }
}
