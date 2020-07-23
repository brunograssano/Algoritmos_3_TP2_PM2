package edu.fiuba.algo3.modelo;

public class RespuestaCorrecta implements RespuestaComun {


    private String textoRespuesta;
    static final int PUNTAJE_RESPUESTA_CORRECTA = 1;


    public RespuestaCorrecta(String textoRespuestaCorrecta) {
        this.textoRespuesta = textoRespuestaCorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaCorrecta();
    }

/*
    @Override
    public int evaluarClasico() {
        return PUNTAJE_RESPUESTA_CORRECTA;
    }

    @Override
    public int evaluarPenalizable() {
        return PUNTAJE_RESPUESTA_CORRECTA;
    }

 */
}
