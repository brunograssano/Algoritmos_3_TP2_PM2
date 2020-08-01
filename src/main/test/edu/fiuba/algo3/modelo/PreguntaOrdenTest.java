package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.*;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaJugadorOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;


public class PreguntaOrdenTest {

    @Test
    public void test01CreoUnaPreguntaOrdenSeOrdenaCorrectamenteYSeDevuelveUnPunto(){

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple opcion1 = new OpcionSimple("1");
        OpcionSimple opcion2 = new OpcionSimple("2");
        OpcionSimple opcion3 = new OpcionSimple("3");
        OpcionSimple opcion4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,opcionesOrdenadas);

        ArrayList<OpcionSimple> opcionesJugador = new ArrayList<>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion2);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion4);

        RespuestaJugadorOrderedChoice respuestaJugadorOC = new RespuestaJugadorOrderedChoice(opcionesJugador);

        Resultado resultado = preguntaOrden.evaluar(respuestaJugadorOC);

        assertEquals(1,resultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test02CreoUnaPreguntaOrdenSeOrdenaIncorrectamenteYSeDevuelveCeroPuntos(){

        String enunciado = "Ordenar de menor a mayor";

        OpcionSimple opcion1 = new OpcionSimple("1");
        OpcionSimple opcion2 = new OpcionSimple("2");
        OpcionSimple opcion3 = new OpcionSimple("3");
        OpcionSimple opcion4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> opcionesOrdenadas = new ArrayList<>();
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,opcionesOrdenadas);

        ArrayList<OpcionSimple> opcionesJugador = new ArrayList<>();
        opcionesJugador.add(opcion1);
        opcionesJugador.add(opcion3);
        opcionesJugador.add(opcion4);
        opcionesJugador.add(opcion2);

        RespuestaJugadorOrderedChoice respuestaJugadorOC = new RespuestaJugadorOrderedChoice(opcionesJugador);

        Resultado resultado = preguntaOrden.evaluar(respuestaJugadorOC);

        assertEquals(0,resultado.obtenerPuntos().valorNumerico());
    }
}
