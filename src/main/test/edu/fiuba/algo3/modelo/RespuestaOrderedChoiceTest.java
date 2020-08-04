package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.groupChoice.Grupo;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestasJugador.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RespuestaOrderedChoiceTest {

    @Test
    public void test01CreoUnaRespuestaOrderedChoiceYLaComparoConUnaIgual(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        Orden orden1 = new Orden(elementosOrden1);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(orden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento4);

        Orden orden2 = new Orden(elementosOrden2);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(orden2);

        assertEquals(true, unaRespuesta.esIgual(otraRespuesta));
    }

    @Test
    public void test02CreoUnaRespuestaOrderedChoiceYLaComparoConUnaDistinta(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        Orden orden1 = new Orden(elementosOrden1);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(orden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento4);

        Orden orden2 = new Orden(elementosOrden2);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(orden2);

        assertEquals(false, unaRespuesta.esIgual(otraRespuesta));
    }

    @Test
    public void test03CreoUnaRespuestaOrderedChoiceYLaComparoConUnaRespuestaGroupChoice(){

        OpcionSimple elemento1 = new OpcionSimple("1");
        OpcionSimple elemento2 = new OpcionSimple("2");
        OpcionSimple elemento3 = new OpcionSimple("3");
        OpcionSimple elemento4 = new OpcionSimple("4");

        ArrayList<OpcionSimple> elementosOrden1 = new ArrayList<>();
        elementosOrden1.add(elemento1);
        elementosOrden1.add(elemento2);
        elementosOrden1.add(elemento3);
        elementosOrden1.add(elemento4);

        Orden orden1 = new Orden(elementosOrden1);

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(orden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);

        Grupo unGrupo = new Grupo("Un nombre",elementosOrden2);
        Grupo otroGrupo = new Grupo("Otro nombre",elementosOrden2);

        RespuestaGroupChoice otraRespuesta = new RespuestaGroupChoice(unGrupo,otroGrupo);

        assertEquals(false, unaRespuesta.esIgual(otraRespuesta));
    }
}
