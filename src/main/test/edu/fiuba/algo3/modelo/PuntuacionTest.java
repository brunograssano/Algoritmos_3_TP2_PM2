package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PuntuacionTest {

    @Test
    public void test01CreoUnaPuntuacionVaciaYPidosuValorNumericoDaCero(){
        Puntuacion puntos = new Puntuacion();
        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaPuntuacionYAgrego10PuntosPositivosPidoRepreentacionYDaDiez(){
        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }
        assertEquals(10,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaPuntuacionYAgrego100PuntosPositivosY50NegativosPidorepresentacionYDaCincuenta(){
        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<100;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }
        for (int i=0;i<50;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }
        assertEquals(50,puntos.valorNumerico());
    }

    @Test
    public void test04AgregoVariasPuntuacionesYUnaConUnPuntoPositivoPidoRepresentacionDaUno(){
        Puntuacion puntos = new Puntuacion();
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.agregarPunto(new Puntuacion());
        puntuacion.agregarPunto(new PuntoPositivo());
        puntos.agregarPunto(puntuacion);

        assertEquals(1,puntos.valorNumerico());
    }

    @Test
    public void test05AgregoAUnaPuntuacionVariosPuntosNulosPidoValorNumericoDaCero(){
        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<20;i++) {
            puntos.agregarPunto(new PuntoNulo());
        }
        assertEquals(0,puntos.valorNumerico());
    }

    @Test
    public void test06AgregoAUnaPuntuacionQuincePuntosNegativosRepresentacionDaMenosQuince(){
        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<15;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }
        assertEquals(-15,puntos.valorNumerico());
    }

}
