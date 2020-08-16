package edu.fiuba.algo3.modelo.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.puntos.Punto;

public interface EstadoResultadoParcial {

    void agregarPunto(Punto unPunto);

    Punto obtenerPuntos();

    void multiplicarPuntos(Multiplicador multiplicador, Jugador unJugador);

    void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador);
}
