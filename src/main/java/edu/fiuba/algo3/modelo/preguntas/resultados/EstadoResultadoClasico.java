package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;

public interface EstadoResultadoClasico {

    void agregarPunto(Punto unPunto);

    Punto obtenerPuntos();
}
