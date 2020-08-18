package edu.fiuba.algo3.modelo.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.PuntoNulo;

public class EstadoIncorrecto implements EstadoResultadoParcial,EstadoResultadoClasico {

    private PuntoNulo puntoNulo;

    public EstadoIncorrecto(){
        puntoNulo = new PuntoNulo();
    }

    @Override
    public void agregarPunto(Punto unPunto) {
    }

    @Override
    public Punto obtenerPuntos() {
        return puntoNulo;
    }

    @Override
    public void multiplicarPuntos(Multiplicador multiplicador, Jugador unJugador) {

    }

    @Override
    public void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador) {
        analizador.agregarSituacion(new UsuarioSeEquivoco(resultado));
    }


}
