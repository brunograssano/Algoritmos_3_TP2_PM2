package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;

public class EstadoCorrectoClasico implements EstadoResultadoClasico {

    private int cantidadDeRespuestasCorrectasTotales;
    private Puntuacion puntosTemporales;
    private Puntuacion punto;

    public EstadoCorrectoClasico(int unaCantidadDeRespuesasCorrectasTotales){
        cantidadDeRespuestasCorrectasTotales = unaCantidadDeRespuesasCorrectasTotales;
        puntosTemporales = new Puntuacion();
        punto = new Puntuacion();
        punto.agregarPunto(new PuntoPositivo());
    }

    @Override
    public void agregarPunto(Punto unPunto) {
        puntosTemporales.agregarPunto(unPunto);
    }

    @Override
    public Punto obtenerPuntos() {
        if(puntosTemporales.representar() != cantidadDeRespuestasCorrectasTotales){
            return new PuntoNulo();
        }
        return punto;
    }

    @Override
    public void multiplicarPuntos(Multiplicador multiplicador, Jugador unJugador) {
        punto = multiplicador.usarEnPuntos(punto,unJugador);
    }

    @Override
    public void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador) {
        if(puntosTemporales.representar() == cantidadDeRespuestasCorrectasTotales) {
            analizador.agregarSituacion(new UsuarioRespondioBien(resultado));
        }
        else{
            analizador.agregarSituacion(new UsuarioSeEquivoco(resultado));
        }
    }

}
