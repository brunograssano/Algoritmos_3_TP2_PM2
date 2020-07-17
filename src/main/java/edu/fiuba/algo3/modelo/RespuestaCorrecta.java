package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta extends Respuesta {


    public RespuestaCorrecta(String textoRespuestaCorrecta) {
        super(textoRespuestaCorrecta);
        this.puntos = 1;
    }

    @Override
    public int evaluar() {
        return puntos;
    }



}
