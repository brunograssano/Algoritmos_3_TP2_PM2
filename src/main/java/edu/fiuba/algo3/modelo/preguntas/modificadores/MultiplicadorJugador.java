package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaExcepcion;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
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
        throw new ModificadorNoAptoParaPreguntaExcepcion();
    }

    @Override
    public void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada) {
        throw new ModificadorNoAptoParaPreguntaExcepcion();
    }

    @Override
    public void aplicar(Jugador jugador,Resultado resultadoJugador1, Resultado resultadoJugador2) {
        if(this.jugador == jugador){
            resultadoJugador1.aplicarMultiplicador(this);
        }
        else{
            resultadoJugador2.aplicarMultiplicador(this);
        }
    }

    public void usarEnPuntos(Puntuacion puntos) {
        puntos.multiplicar(factor);
    }

}
