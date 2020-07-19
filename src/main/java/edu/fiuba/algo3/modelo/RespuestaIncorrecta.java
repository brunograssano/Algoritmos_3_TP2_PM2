package edu.fiuba.algo3.modelo;

public class RespuestaIncorrecta extends Respuesta{

    static final int PUNTAJE_RESPUESTA_INCORRECTA = 0;

    public RespuestaIncorrecta(String textoRespuestaIncorrecta) {
        super(textoRespuestaIncorrecta);
        this.puntos = PUNTAJE_RESPUESTA_INCORRECTA;
    }

    @Override
    public int evaluar() {
        return puntos;
    }
}
