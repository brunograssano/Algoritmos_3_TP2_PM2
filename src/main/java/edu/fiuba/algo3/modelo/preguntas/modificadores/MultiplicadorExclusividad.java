package edu.fiuba.algo3.modelo.preguntas.modificadores;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;

public class MultiplicadorExclusividad implements Multiplicador {

    private static int VALOR_MULTIPLICADOR_EXCLUSIVIDAD = 2;

    @Override
    public void usarEnPuntos(Puntuacion puntos) {
        puntos.multiplicar(VALOR_MULTIPLICADOR_EXCLUSIVIDAD);
    }
}
