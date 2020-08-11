package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrdenTest {

    @Test
    public void test01CuandoSeCreanDosOrdenesIgualesDeTresRespuestasLaComparacionDevuelveQueSonIguales() {

        OpcionSimple opcion1 = new OpcionSimple("Soy la primer respuesta :) ");
        OpcionSimple opcion2 = new OpcionSimple("Soy la segunda respuesta :| ");
        OpcionSimple opcion3 = new OpcionSimple("Soy la ultima respuesta :(");

        ArrayList<OpcionSimple> unasOpcionesOrdenadas = new ArrayList<>();
        unasOpcionesOrdenadas.add(opcion1);
        unasOpcionesOrdenadas.add(opcion2);
        unasOpcionesOrdenadas.add(opcion3);

        Orden unOrden = new Orden(unasOpcionesOrdenadas);
        Orden otroOrden = new Orden(unasOpcionesOrdenadas);

        assert(unOrden.esIgual(otroOrden) && otroOrden.esIgual(unOrden));
    }

    @Test
    public void test02CuandoSeCreanDosOrdenesIgualesDeCincoRespuestasLaComparacionDevuelveQueSonIguales() {

        OpcionSimple opcion1 = new OpcionSimple("Soy la primer respuesta :) ");
        OpcionSimple opcion2 = new OpcionSimple("Soy la segunda respuesta <:| ");
        OpcionSimple opcion3 = new OpcionSimple("Soy la tercer respuesta :| ");
        OpcionSimple opcion4 = new OpcionSimple("Soy la cuarta respuesta >:^| ");
        OpcionSimple opcion5 = new OpcionSimple("Soy la ultima respuesta :(");

        ArrayList<OpcionSimple> unasOpcionesOrdenadas = new ArrayList<>();
        unasOpcionesOrdenadas.add(opcion1);
        unasOpcionesOrdenadas.add(opcion2);
        unasOpcionesOrdenadas.add(opcion3);
        unasOpcionesOrdenadas.add(opcion4);
        unasOpcionesOrdenadas.add(opcion5);

        ArrayList<OpcionSimple> otrasOpcionesOrdenadas = new ArrayList<>();
        otrasOpcionesOrdenadas.add(opcion1);
        otrasOpcionesOrdenadas.add(opcion2);
        otrasOpcionesOrdenadas.add(opcion3);
        otrasOpcionesOrdenadas.add(opcion4);
        otrasOpcionesOrdenadas.add(opcion5);


        Orden unOrden = new Orden(unasOpcionesOrdenadas);
        Orden otroOrden = new Orden(otrasOpcionesOrdenadas);

        assert(unOrden.esIgual(otroOrden) && otroOrden.esIgual(unOrden));
    }

    @Test
    public void test03CuandoSeCreanDosOrdenesDistintosDeTresRespuestasLaComparacionDevuelveQueSonDistintos() {

        OpcionSimple opcion1 = new OpcionSimple("Soy la primer respuesta :) ");
        OpcionSimple opcion2 = new OpcionSimple("Soy la segunda respuesta :| ");
        OpcionSimple opcion3 = new OpcionSimple("Soy la ultima respuesta :(");

        ArrayList<OpcionSimple> unasOpcionesOrdenadas = new ArrayList<>();
        unasOpcionesOrdenadas.add(opcion1);
        unasOpcionesOrdenadas.add(opcion2);
        unasOpcionesOrdenadas.add(opcion3);

        ArrayList<OpcionSimple> otrasOpcionesOrdenadas = new ArrayList<>();
        otrasOpcionesOrdenadas.add(opcion2);
        otrasOpcionesOrdenadas.add(opcion3);
        otrasOpcionesOrdenadas.add(opcion1);

        Orden unOrden = new Orden(unasOpcionesOrdenadas);
        Orden otroOrden = new Orden(otrasOpcionesOrdenadas);

        assert(!unOrden.esIgual(otroOrden) && !otroOrden.esIgual(unOrden));
    }
    @Test
    public void test04CuandoSeCreanDosOrdenesDistintosDeCincoRespuestasLaComparacionDevuelveQueSonDistintos() {

        OpcionSimple opcion1 = new OpcionSimple("Soy la primer respuesta :) ");
        OpcionSimple opcion2 = new OpcionSimple("Soy la segunda respuesta <:| ");
        OpcionSimple opcion3 = new OpcionSimple("Soy la tercer respuesta :| ");
        OpcionSimple opcion4 = new OpcionSimple("Soy la cuarta respuesta >:^| ");
        OpcionSimple opcion5 = new OpcionSimple("Soy la ultima respuesta :(");

        ArrayList<OpcionSimple> unasOpcionesOrdenadas = new ArrayList<>();
        unasOpcionesOrdenadas.add(opcion1);
        unasOpcionesOrdenadas.add(opcion2);
        unasOpcionesOrdenadas.add(opcion3);
        unasOpcionesOrdenadas.add(opcion4);
        unasOpcionesOrdenadas.add(opcion5);

        ArrayList<OpcionSimple> otrasOpcionesOrdenadas = new ArrayList<>();
        otrasOpcionesOrdenadas.add(opcion2);
        otrasOpcionesOrdenadas.add(opcion3);
        otrasOpcionesOrdenadas.add(opcion1);
        otrasOpcionesOrdenadas.add(opcion5);
        otrasOpcionesOrdenadas.add(opcion4);

        Orden unOrden = new Orden(unasOpcionesOrdenadas);
        Orden otroOrden = new Orden(otrasOpcionesOrdenadas);

        assert(!unOrden.esIgual(otroOrden) && !otroOrden.esIgual(unOrden));
    }
}
