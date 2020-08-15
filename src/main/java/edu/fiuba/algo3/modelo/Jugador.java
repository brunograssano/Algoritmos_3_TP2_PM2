package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.puntos.Punto;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private Puntuacion puntos;
    private ArrayList<MultiplicadorJugador> multiplicadores;
    private ArrayList<Exclusividad> exclusividades;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = new Puntuacion();

        multiplicadores = new ArrayList<>();
        multiplicadores.add(new MultiplicadorJugador(this,2));
        multiplicadores.add(new MultiplicadorJugador(this,3));

        exclusividades = new ArrayList<>();
        exclusividades.add(new Exclusividad(this));
        exclusividades.add(new Exclusividad(this));
    }

    public void sumarPuntos(Punto unosPuntos){
        puntos.agregarPunto(unosPuntos);
    }

    public int obtenerPuntos(){
        return puntos.representar();
    }

    public void pierdeExclusividad(Exclusividad exclusividad) {
        exclusividades.remove(exclusividad);
    }

    public void pierdeMultiplicador(MultiplicadorJugador multiplicadorJugador) {
        multiplicadores.remove(multiplicadorJugador);
    }

    public String obtenerNombre() {
        return nombre;
    }

    public Jugador compararYObtenerGanador(Jugador jugadorContrario){
        if(this.obtenerPuntos() < jugadorContrario.obtenerPuntos()){
            return jugadorContrario;
        }
        return this;
    }

    public ArrayList<MultiplicadorJugador> multiplicadores() {
        return multiplicadores;
    }

    public ArrayList<Exclusividad> exclusividades() {
        return exclusividades;
    }

}
