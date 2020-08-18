package edu.fiuba.algo3.modelo.modificadores.exclusividad;

public class ExclusividadFueUsada implements EstadoAnalizador {
    @Override
    public EstadoAnalizador agregarSituacion(SituacionesExclusividad situacion) {
        return this;
    }
}
