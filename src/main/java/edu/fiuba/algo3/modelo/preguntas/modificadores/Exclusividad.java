package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class Exclusividad implements Modificador {

    private Jugador jugador;

    public Exclusividad(Jugador unJugador){
        jugador = unJugador;
    }

    @Override
    public void usarEnPuntaje(PuntajePenalizable puntajePenalizable, ArrayList<Modificador> modificadoresDeLaJugada) {
        throw new ModificadorNoAptoParaPreguntaException();
    }

    @Override
    public void usarEnPuntaje(PuntajeClasico puntajeClasico, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificadoresDeLaJugada.add(this);
        jugador.pierdeModificador(this);
    }

    @Override
    public void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificadoresDeLaJugada.add(this);
        jugador.pierdeModificador(this);
    }

    @Override
    public void aplicar(Jugador jugador, Resultado resultadoJugador1, Resultado resultadoJugador2) {
        AnalizadorExclusividad analizador = new AnalizadorExclusividad();
        resultadoJugador1.aplicaExclusividad(analizador);
        resultadoJugador2.aplicaExclusividad(analizador);
        analizador.analizarSituacion();
    }

}
