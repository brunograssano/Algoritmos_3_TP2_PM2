package edu.fiuba.algo3.modelo.modificadores.exclusividad;

public class EstadoUnaSituacionAnalizador implements EstadoAnalizador {
    @Override
    public EstadoAnalizador agregarSituacion(SituacionesExclusividad situacionDelJugador1) {
        return new EstadoDosSituacionesAnalizador(situacionDelJugador1);
    }
}
