package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta extends Respuesta {

    static final int PUNTAJE_RESPUESTA_CORRECTA = 1;


    public RespuestaCorrecta(String textoRespuestaCorrecta) {
        super(textoRespuestaCorrecta);
        this.puntos = PUNTAJE_RESPUESTA_CORRECTA;
    }

    @Override
    public int evaluar() {
        return puntos;
    }



}
