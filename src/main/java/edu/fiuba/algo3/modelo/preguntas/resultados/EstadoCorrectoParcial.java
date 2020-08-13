package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;

public class EstadoCorrectoParcial implements EstadoResultadoParcial {

    private Puntuacion puntos;

    public EstadoCorrectoParcial(){
        puntos = new Puntuacion();
    }

    @Override
    public void agregarPunto(Punto unPunto) {
        puntos.agregarPunto(unPunto);
    }

    @Override
    public Punto obtenerPuntos() {
        return puntos;
    }

    @Override
    public void multiplicarPuntos(Multiplicador multiplicador, Jugador unJugador) {
        puntos = multiplicador.usarEnPuntos(puntos,unJugador);
    }

    @Override
    public void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador) {
        analizador.agregarSituacion(new UsuarioRespondioBien(resultado));
    }
}
