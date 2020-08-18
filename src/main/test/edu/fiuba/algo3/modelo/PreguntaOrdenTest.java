package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.FabricaDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PreguntaOrdenTest {

    Jugador jugador;
    ArrayList<OpcionSimple> opcionesOrdenadas;
    ArrayList<OpcionSimple> opcionesJugador;
    String enunciado;

    OpcionSimple opcion1;
    OpcionSimple opcion2;
    OpcionSimple opcion3;
    OpcionSimple opcion4;

    @BeforeEach
    public void setUp(){
        jugador = new Jugador("Prueba");
        opcionesOrdenadas = new ArrayList<>();
        opcionesJugador = new ArrayList<>();
        enunciado = "Ordenar de menor a mayor";
        opcion1 = new OpcionSimple("1");
        opcion2 = new OpcionSimple("2");
        opcion3 = new OpcionSimple("3");
        opcion4 = new OpcionSimple("4");
    }

    @Test
    public void test01CreoUnaPreguntaOrdenSeOrdenaCorrectamenteYSeDevuelveUnPunto(){
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,opcionesOrdenadas);

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
        opcionesOrdenadas.add(opcion1);
        opcionesOrdenadas.add(opcion2);
        opcionesOrdenadas.add(opcion3);
        opcionesOrdenadas.add(opcion4);

        Pregunta preguntaOrden = FabricaDePreguntas.CrearOrden(enunciado,opcionesOrdenadas);

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
