package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.modificadores.Modificador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Puntuacion puntos;
    private ArrayList<Modificador> modificadores;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = new Puntuacion();
        modificadores = new ArrayList<Modificador>();
        modificadores.add(new Multiplicador(this,2));
        modificadores.add(new Multiplicador(this,3));
    }

    public void sumarPuntos(Punto unosPuntos){
        puntos.agregarPunto(unosPuntos);
    }

    public int obtenerPuntos(){
        return puntos.valorNumerico();
    }

    public void pierdeModificador(Modificador modificador) {
        modificadores.remove(modificador);
    }
}
