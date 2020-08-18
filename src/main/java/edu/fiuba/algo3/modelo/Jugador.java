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

    private static final int VALOR_PRIMER_MULTIPLICADOR = 2;
    private static final int VALOR_SEGUNDO_MULTIPLICADOR = 3;

    public Jugador(String nombre) {
        this.nombre = nombre;
        puntos = new Puntuacion();

        multiplicadores = new ArrayList<>();
        multiplicadores.add(new MultiplicadorJugador(this,VALOR_PRIMER_MULTIPLICADOR));
        multiplicadores.add(new MultiplicadorJugador(this,VALOR_SEGUNDO_MULTIPLICADOR));

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

    public FinJuego compararYObtenerGanador(Jugador jugadorContrario){
        if(this.obtenerPuntos() < jugadorContrario.obtenerPuntos()){
            return new GanadorJuego(jugadorContrario);
        }else if (this.obtenerPuntos() > jugadorContrario.obtenerPuntos()){
            return new GanadorJuego(this);
        }
        return new JuegoEmpatado();
    }

    public ArrayList<MultiplicadorJugador> multiplicadores() {
        return multiplicadores;
    }

    public ArrayList<Exclusividad> exclusividades() {
        return exclusividades;
    }

}
