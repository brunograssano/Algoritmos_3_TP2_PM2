package edu.fiuba.algo3.modelo.modificadores;

import edu.fiuba.algo3.modelo.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import java.util.ArrayList;

public interface Modificador {

    void usarEnPuntaje(PuntajePenalizable puntajePenalizable, ArrayList<Modificador> modificadoresDeLaJugada);

    void usarEnPuntaje(PuntajeClasico puntajeClasico, ArrayList<Modificador> modificadoresDeLaJugada);

    void usarEnPuntaje(PuntajeParcial puntajeParcial, ArrayList<Modificador> modificadoresDeLaJugada);

    void aplicar(Resultado resultadoJugador1, Resultado resultadoJugador2);
}
