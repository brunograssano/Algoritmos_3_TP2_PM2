package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

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
    public void multiplicarPuntos(Multiplicador multiplicador) {
        multiplicador.usarEnPuntos(puntos);
    }

    @Override
    public void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador) {
        analizador.agregarSituacion(new UsuarioRespondioBien(resultado));
    }
}
