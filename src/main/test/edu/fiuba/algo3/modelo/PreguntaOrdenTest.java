package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaOrdenTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }

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

        RespuestaOrderedChoice respuestaJugadorOC = new RespuestaOrderedChoice(opcionesJugador);

        Resultado resultado = preguntaOrden.responder(respuestaJugadorOC,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(1, puntosRepresentados.representar());
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

        RespuestaOrderedChoice respuestaJugadorOC = new RespuestaOrderedChoice(opcionesJugador);

        Resultado resultado = preguntaOrden.responder(respuestaJugadorOC,jugador);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        resultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0, puntosRepresentados.representar());
    }
}
