package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


public class PreguntaOrdenTest {

    @Test
    public void test01CreoUnaPreguntaOrdenSeOrdenaCorrectamenteYSeDevuelveUnPunto(){

        String enunciado = "Ordenar de menor a mayor";

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();


        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaOrden1);
        respuestasJugador.add(respuestaOrden2);
        respuestasJugador.add(respuestaOrden3);
        respuestasJugador.add(respuestaOrden4);

        RespuestaJugadorOrderedChoice respuestaJugadorOC = new RespuestaJugadorOrderedChoice(respuestasJugador);

        Resultado resultado = preguntaOrden.evaluar(respuestaJugadorOC);

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test02CreoUnaPreguntaOrdenSeOrdenaIncorrectamenteYSeDevuelveCeroPuntos(){

        String enunciado = "Ordenar de menor a mayor";

        RespuestaOrden respuestaOrden1 = new RespuestaOrden("1");
        RespuestaOrden respuestaOrden2 = new RespuestaOrden("2");
        RespuestaOrden respuestaOrden3 = new RespuestaOrden("3");
        RespuestaOrden respuestaOrden4 = new RespuestaOrden("4");

        ArrayList<RespuestaOrden> respuestasOrdenadas = new ArrayList<>();


        respuestasOrdenadas.add(respuestaOrden1);
        respuestasOrdenadas.add(respuestaOrden2);
        respuestasOrdenadas.add(respuestaOrden3);
        respuestasOrdenadas.add(respuestaOrden4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,respuestasOrdenadas);

        ArrayList<RespuestaGrupal> respuestasJugador = new ArrayList<>();
        respuestasJugador.add(respuestaOrden1);
        respuestasJugador.add(respuestaOrden3);
        respuestasJugador.add(respuestaOrden4);
        respuestasJugador.add(respuestaOrden2);

        RespuestaJugadorOrderedChoice respuestaJugadorOC = new RespuestaJugadorOrderedChoice(respuestasJugador);

        Resultado resultado = preguntaOrden.evaluar(respuestaJugadorOC);

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }
}
