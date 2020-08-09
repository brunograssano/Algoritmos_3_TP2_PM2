package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaOrderedChoice;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento4);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(elementosOrden2);

        assertTrue(unaRespuesta.esIgual(otraRespuesta));
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

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento3);
        elementosOrden2.add(elemento2);
        elementosOrden2.add(elemento4);

        RespuestaOrderedChoice otraRespuesta = new RespuestaOrderedChoice(elementosOrden2);

        assertFalse(unaRespuesta.esIgual(otraRespuesta));
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

        RespuestaOrderedChoice unaRespuesta = new RespuestaOrderedChoice(elementosOrden1);

        ArrayList<OpcionSimple> elementosOrden2 = new ArrayList<>();
        elementosOrden2.add(elemento1);
        elementosOrden2.add(elemento2);

        RespuestaGroupChoice otraRespuesta = new RespuestaGroupChoice("Un nombre", elementosOrden2, "Otro nombre", elementosOrden2);

        assertFalse(unaRespuesta.esIgual(otraRespuesta));
    }
}
