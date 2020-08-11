package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.UsuarioSeEquivoco;
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
