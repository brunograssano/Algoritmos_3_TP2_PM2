package edu.fiuba.algo3.modelo;

public class RespuestaIncorrecta implements RespuestaComun {

    private String textoRespuesta;
    static final int PUNTAJE_RESPUESTA_INCORRECTA = 0;
    static final int PENALIZACION_RESPUESTA_INCORRECTA = -1;

    public RespuestaIncorrecta(String textoRespuestaIncorrecta) {
        this.textoRespuesta = textoRespuestaIncorrecta;
    }

    @Override
    public void evaluar(Resultado unResultado) {
        unResultado.sumarRespuestaIncorrecta();
    }
/*
    @Override
    public int evaluarClasico() {
        return PUNTAJE_RESPUESTA_INCORRECTA;
    }

    @Override
    public int evaluarPenalizable() {
        return PENALIZACION_RESPUESTA_INCORRECTA;
    }
 */

}
