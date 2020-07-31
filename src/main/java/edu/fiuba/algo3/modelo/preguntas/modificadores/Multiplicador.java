package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.modelo.Jugador;

public class Multiplicador implements Modificador{

    private Jugador jugador;
    private int factor;

    public Multiplicador(Jugador unJugador,int factor){
        jugador=unJugador;
    }


}
