package edu.fiuba.algo3.modelo;

public class RespuestaIncorrecta extends Respuesta{
    public RespuestaIncorrecta(String textoRespuestaIncorrecta) {
        super(textoRespuestaIncorrecta);
        this.puntos = 0;
    }

    @Override
    public int evaluar() {
        return puntos;
    }
}
