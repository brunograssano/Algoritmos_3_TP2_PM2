package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.modificadores.MultiplicadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoNulo;
import edu.fiuba.algo3.modelo.preguntas.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.preguntas.puntos.Puntuacion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorExclusividadTest {
    @Test
    public void test01CreoUnaPuntuacionLeAgrego10PuntosPositivosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo20(){

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        unMultiplicador.usarEnPuntos(puntos);

        assertEquals(20,puntos.valorNumerico());
    }

    @Test
    public void test02CreoUnaPuntuacionLeAgrego5PuntosNegativosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo10Negativos(){

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<5;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        unMultiplicador.usarEnPuntos(puntos);

        assertEquals(-10,puntos.valorNumerico());
    }

    @Test
    public void test03CreoUnaPuntuacionLeAgrego10PuntosNulosYLeAplicoElMultiplicadorDeExclusividadAhoraTengo0Puntos(){

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoNulo());
        }
        MultiplicadorExclusividad unMultiplicador = new MultiplicadorExclusividad();

        unMultiplicador.usarEnPuntos(puntos);

        assertEquals(0,puntos.valorNumerico());
    }
}
