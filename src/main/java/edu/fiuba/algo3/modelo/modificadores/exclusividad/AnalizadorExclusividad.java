package edu.fiuba.algo3.modelo.modificadores.exclusividad;

public class AnalizadorExclusividad {

    private EstadoAnalizador estado;

    public AnalizadorExclusividad(){
        estado = new EstadoUnaSituacionAnalizador();
    }

    public void agregarSituacion(SituacionesExclusividad situacion){
        estado = estado.agregarSituacion(situacion);
    }
}
