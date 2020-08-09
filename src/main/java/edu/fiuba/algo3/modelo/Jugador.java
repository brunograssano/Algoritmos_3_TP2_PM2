package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.modificadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Puntuacion puntos;
    private ArrayList<Modificador> modificadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = new Puntuacion();
        modificadores = new ArrayList<Modificador>();
        modificadores.add(new MultiplicadorJugador(this,2));
        modificadores.add(new MultiplicadorJugador(this,3));
    }

    public void sumarPuntos(Punto unosPuntos){
        puntos.agregarPunto(unosPuntos);
    }

    public int obtenerPuntos(){
        return puntos.representar();
    }

    public void pierdeModificador(Modificador modificador) {
        modificadores.remove(modificador);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Jugador compararYObtenerGanador(Jugador otroJugador){
        return jugadorConMasPuntos(otroJugador);
    }

    private Jugador jugadorConMasPuntos(Jugador otroJugador){
        if(this.obtenerPuntos() > otroJugador.obtenerPuntos()){
            return this;
        }else if(this.obtenerPuntos() < otroJugador.obtenerPuntos()){
            return otroJugador;
        }
        return null;
    }
}
