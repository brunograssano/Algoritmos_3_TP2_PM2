package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaExcepcion;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class Exclusividad implements Modificador {

    @Override
    public void usarEnPuntaje(PuntajePenalizable puntajePenalizable, ArrayList<Modificador> modificadoresDeLaJugada) {
        throw new ModificadorNoAptoParaPreguntaExcepcion();
    }

    @Override
    public void usarEnPuntaje(PuntajeClasico puntajeClasico, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificadoresDeLaJugada.add(this);
    }

    @Override
    public void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificadoresDeLaJugada.add(this);
    }

    @Override
    public void aplicar(Jugador jugador, Resultado resultadoJugador1, Resultado resultadoJugador2) {

    }

}
