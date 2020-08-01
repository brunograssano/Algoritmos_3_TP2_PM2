package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.orderedChoice.Orden;
import edu.fiuba.algo3.modelo.preguntas.orderedChoice.RespuestaOrden;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class OrdenTest {

    @Test
    public void test01CuandoSeCreanDosOrdenesIgualesDeTresRespuestasLaComparacionDevuelveQueSonIguales() {

        RespuestaOrden respuesta1 = new RespuestaOrden("Soy la primer respuesta :) ");
        RespuestaOrden respuesta2 = new RespuestaOrden("Soy la segunda respuesta :| ");
        RespuestaOrden respuesta3 = new RespuestaOrden("Soy la ultima respuesta :(");
        ArrayList<RespuestaOrden> unasRespuestasOrdenadas = new ArrayList<>();
        unasRespuestasOrdenadas.add(respuesta1);
        unasRespuestasOrdenadas.add(respuesta2);
        unasRespuestasOrdenadas.add(respuesta3);

        Orden unOrden = new Orden(unasRespuestasOrdenadas);
        Orden otroOrden = new Orden(unasRespuestasOrdenadas);

        assert(unOrden.esIgual(otroOrden) && otroOrden.esIgual(unOrden));
    }

    @Test
    public void test02CuandoSeCreanDosOrdenesIgualesDeCincoRespuestasLaComparacionDevuelveQueSonIguales() {

        RespuestaOrden respuesta1 = new RespuestaOrden("Soy la primer respuesta :) ");
        RespuestaOrden respuesta2 = new RespuestaOrden("Soy la segunda respuesta <:| ");
        RespuestaOrden respuesta3 = new RespuestaOrden("Soy la tercer respuesta :| ");
        RespuestaOrden respuesta4 = new RespuestaOrden("Soy la cuarta respuesta >:^| ");
        RespuestaOrden respuesta5 = new RespuestaOrden("Soy la ultima respuesta :(");

        ArrayList<RespuestaOrden> unasRespuestasOrdenadas = new ArrayList<>();
        unasRespuestasOrdenadas.add(respuesta1);
        unasRespuestasOrdenadas.add(respuesta2);
        unasRespuestasOrdenadas.add(respuesta3);
        unasRespuestasOrdenadas.add(respuesta4);
        unasRespuestasOrdenadas.add(respuesta5);

        Orden unOrden = new Orden(unasRespuestasOrdenadas);
        Orden otroOrden = new Orden(unasRespuestasOrdenadas);

        assert(unOrden.esIgual(otroOrden) && otroOrden.esIgual(unOrden));
    }

    @Test
    public void test03CuandoSeCreanDosOrdenesDistintosDeTresRespuestasLaComparacionDevuelveQueSonDistintos() {

        RespuestaOrden respuesta1 = new RespuestaOrden("Soy la primer respuesta :) ");
        RespuestaOrden respuesta2 = new RespuestaOrden("Soy la segunda respuesta :| ");
        RespuestaOrden respuesta3 = new RespuestaOrden("Soy la ultima respuesta :(");

        ArrayList<RespuestaOrden> unasRespuestasOrdenadas = new ArrayList<>();
        unasRespuestasOrdenadas.add(respuesta1);
        unasRespuestasOrdenadas.add(respuesta2);
        unasRespuestasOrdenadas.add(respuesta3);

        ArrayList<RespuestaOrden> otrasRespuestasOrdenadas = new ArrayList<>();
        otrasRespuestasOrdenadas.add(respuesta2);
        otrasRespuestasOrdenadas.add(respuesta3);
        otrasRespuestasOrdenadas.add(respuesta1);

        Orden unOrden = new Orden(unasRespuestasOrdenadas);
        Orden otroOrden = new Orden(otrasRespuestasOrdenadas);

        assert(!unOrden.esIgual(otroOrden) && !otroOrden.esIgual(unOrden));
    }
    @Test
    public void test04CuandoSeCreanDosOrdenesDistintosDeCincoRespuestasLaComparacionDevuelveQueSonDistintos() {

        RespuestaOrden respuesta1 = new RespuestaOrden("Soy la primer respuesta :) ");
        RespuestaOrden respuesta2 = new RespuestaOrden("Soy la segunda respuesta <:| ");
        RespuestaOrden respuesta3 = new RespuestaOrden("Soy la tercer respuesta :| ");
        RespuestaOrden respuesta4 = new RespuestaOrden("Soy la cuarta respuesta >:^| ");
        RespuestaOrden respuesta5 = new RespuestaOrden("Soy la ultima respuesta :(");

        ArrayList<RespuestaOrden> unasRespuestasOrdenadas = new ArrayList<>();
        unasRespuestasOrdenadas.add(respuesta1);
        unasRespuestasOrdenadas.add(respuesta2);
        unasRespuestasOrdenadas.add(respuesta3);
        unasRespuestasOrdenadas.add(respuesta4);
        unasRespuestasOrdenadas.add(respuesta5);

        ArrayList<RespuestaOrden> otrasRespuestasOrdenadas = new ArrayList<>();
        otrasRespuestasOrdenadas.add(respuesta2);
        otrasRespuestasOrdenadas.add(respuesta3);
        otrasRespuestasOrdenadas.add(respuesta1);
        otrasRespuestasOrdenadas.add(respuesta5);
        otrasRespuestasOrdenadas.add(respuesta4);

        Orden unOrden = new Orden(unasRespuestasOrdenadas);
        Orden otroOrden = new Orden(otrasRespuestasOrdenadas);

        assert(!unOrden.esIgual(otroOrden) && !otroOrden.esIgual(unOrden));
    }
}
