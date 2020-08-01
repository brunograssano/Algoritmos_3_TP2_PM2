package edu.fiuba.algo3.modelo.preguntas.resultados;

import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.Multiplicador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Punto;

public interface EstadoResultadoClasico {

    void agregarPunto(Punto unPunto);

    Punto obtenerPuntos();

    void multiplicarPuntos(Multiplicador multiplicador);

    void verSiAplicaExclusividad(Resultado resultado, AnalizadorExclusividad analizador);
}
