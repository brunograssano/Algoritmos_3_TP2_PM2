package edu.fiuba.algo3.modelo;

public abstract class Respuesta {

    private String textoRespuesta;
    protected int puntos;

    public Respuesta(String textoRespuesta){
        this.textoRespuesta = textoRespuesta;
    }

    public abstract int evaluar();
}
