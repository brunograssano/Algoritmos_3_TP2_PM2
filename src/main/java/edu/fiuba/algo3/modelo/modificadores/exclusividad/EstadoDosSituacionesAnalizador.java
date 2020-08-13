package edu.fiuba.algo3.modelo.modificadores.exclusividad;

public class EstadoDosSituacionesAnalizador implements EstadoAnalizador {

    private SituacionesExclusividad situacionDeljugador1;

    public EstadoDosSituacionesAnalizador(SituacionesExclusividad situacion) {
        this.situacionDeljugador1 = situacion;
    }

    @Override
    public EstadoAnalizador agregarSituacion(SituacionesExclusividad situacionDelJugador2) {
        situacionDeljugador1.compararCon(situacionDelJugador2);
        return new ExclusividadFueUsada();
    }
}
