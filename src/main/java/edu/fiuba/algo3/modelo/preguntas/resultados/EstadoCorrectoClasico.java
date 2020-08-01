package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;

public class EstadoCorrectoClasico implements EstadoResultadoClasico {

    private int cantidadDeRespuestasCorrectasTotales;
    private Puntuacion puntosTemporales;
    private Puntuacion punto;

    public EstadoCorrectoClasico(int unaCantidadDeRespuesasCorrectasTotales){
        cantidadDeRespuestasCorrectasTotales = unaCantidadDeRespuesasCorrectasTotales;
        puntosTemporales = new Puntuacion();
        punto = new Puntuacion();
        punto.agregarPunto(new PuntoPositivo());
    }

    @Override
    public void agregarPunto(Punto unPunto) {
        puntosTemporales.agregarPunto(unPunto);
    }

    @Override
    public Punto obtenerPuntos() {
        if(puntosTemporales.valorNumerico() != cantidadDeRespuestasCorrectasTotales){
            return new PuntoNulo();
        }
        return punto;
    }

    @Override
    public void multiplicarPuntos(Multiplicador multiplicador) {
        multiplicador.usarEnPuntos(punto);
    }

    @Override
    public void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador) {
        if(puntosTemporales.valorNumerico() == cantidadDeRespuestasCorrectasTotales) {
            analizador.agregarSituacion(new UsuarioRespondioBien(resultado));
        }
        else{
            analizador.agregarSituacion(new UsuarioSeEquivoco(resultado));
        }
    }

}
