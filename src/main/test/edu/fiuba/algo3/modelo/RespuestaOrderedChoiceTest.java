package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadErroneaDeRespuestasParaPreguntaException;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoClasico;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class RespuestaOrderedChoiceTest {

    @Test
    public void test01CreoUnaRespuestaOrderedChoiceYLaComparoConUnaIgualYSuma1Punto(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento4);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(elementosOrden2);
        Jugador unJugador = new Jugador("jorgito");
        ResultadoClasico unResultado = new ResultadoClasico(1, unJugador);
        unaRespuesta.compararContra(otraRespuesta,unResultado);
        unJugador.sumarPuntos(unResultado.obtenerPuntos());

        assertEquals(unJugador.obtenerPuntos(),1);
    }

    @Test
    public void test02CreoUnaRespuestaOrderedChoiceYLaComparoConUnaDistintaYSuma0Puntos(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento4);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(elementosOrden2);
        Jugador unJugador = new Jugador("jorgito");
        ResultadoClasico unResultado = new ResultadoClasico(1, unJugador);
        unaRespuesta.compararContra(otraRespuesta,unResultado);
        unJugador.sumarPuntos(unResultado.obtenerPuntos());

        assertEquals(unJugador.obtenerPuntos(),0);
    }

    @Test
    public void test03CreoUnaRespuestaOrderedChoiceYLaComparoConUnaRespuestaGroupChoiceYSuma0Puntos(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);

        RespuestaGroupChoice otraRespuesta = new RespuestaGroupChoice("Un nombre", elementosOrden2, "Otro nombre", elementosOrden2);

        Jugador unJugador = new Jugador("jorgito");
        ResultadoClasico unResultado = new ResultadoClasico(1, unJugador);
        unaRespuesta.compararContra(otraRespuesta,unResultado);
        unJugador.sumarPuntos(unResultado.obtenerPuntos());

        assertEquals(unJugador.obtenerPuntos(),0);
    }

    @Test
    public void test04AlIntentarCrearUnaRespuestaOrderedChoiceConMasDe5OpcionesSeDebeLanzarExcepcion(){

        OpcionSimple opcion1 = new OpcionSimple("Gatito");
        OpcionSimple opcion2 = new OpcionSimple("Conejo");
        OpcionSimple opcion3 = new OpcionSimple("Lagarto");
        OpcionSimple opcion4 = new OpcionSimple("Iguana");
        OpcionSimple opcion5 = new OpcionSimple("Winnie Pooh");
        OpcionSimple opcion6 = new OpcionSimple("Willy");

        ArrayList<OpcionSimple> opcionesOrden = new ArrayList<>();
        opcionesOrden.add(opcion1);
        opcionesOrden.add(opcion2);
        opcionesOrden.add(opcion3);
        opcionesOrden.add(opcion4);
        opcionesOrden.add(opcion5);
        opcionesOrden.add(opcion6);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{ RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(opcionesOrden);}
        );
    }

    @Test
    public void test05AlIntentarCrearUnaRespuestaOrderedChoiceConMenosDe2OpcionesSeDebeLanzarExcepcion(){

        OpcionSimple opcion1 = new OpcionSimple("Gatito");

        ArrayList<OpcionSimple> opcionesOrden = new ArrayList<>();
        opcionesOrden.add(opcion1);

        assertThrows(CantidadErroneaDeRespuestasParaPreguntaException.class,
                ()->{ RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(opcionesOrden);}
        );
    }
}
