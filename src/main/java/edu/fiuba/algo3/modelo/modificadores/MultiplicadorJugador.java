package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

import java.util.ArrayList;

public class MultiplicadorJugador implements Modificador,Multiplicador{

    private Jugador jugador;
    private int factor;

    public MultiplicadorJugador(Jugador unJugador, int factor){
        jugador = unJugador;
        this.factor = factor;
    }

    @Override
    public void usarEnPuntaje(PuntajePenalizable puntajePenalizable, ArrayList<Modificador> modificadoresDeLaJugada) {
        modificadoresDeLaJugada.add(this);
        jugador.pierdeModificador(this);
    }

    @Override
    public void usarEnPuntaje(PuntajeClasico puntajeClasico, ArrayList<Modificador> modificadoresDeLaJugada) {
        throw new ModificadorNoAptoParaPreguntaException();
    }

    @Override
    public void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada) {
        throw new ModificadorNoAptoParaPreguntaException();
    }



    @Override
    public void aplicar(Resultado resultadoJugador1, Resultado resultadoJugador2) {
        resultadoJugador1.aplicarMultiplicador(this);
        resultadoJugador2.aplicarMultiplicador(this);
    }

    public Puntuacion usarEnPuntos(Puntuacion puntos, Jugador unJugador) {
        if(jugador == unJugador) {
            return puntos.multiplicar(factor);
        }
        return puntos;
    }

}
