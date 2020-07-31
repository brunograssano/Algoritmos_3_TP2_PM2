package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.preguntas.groupChoice.RespuestaGrupo;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import java.util.ArrayList;

public interface RespuestaJugador {
    void evaluar(Resultado unResultado);

    void evaluarOrden(Resultado unResultado, ArrayList<RespuestaOrden> respuestasOrdenadasCorrectamente);
    void evaluarGrupo(Resultado unResultado, ArrayList<RespuestaGrupo> respuestaGrupo1, ArrayList<RespuestaGrupo> respuestaGrupo2 );
}
