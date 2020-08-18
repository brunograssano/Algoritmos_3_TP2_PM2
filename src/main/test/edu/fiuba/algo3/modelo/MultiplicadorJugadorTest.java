package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplicadorJugadorTest {

    Jugador unJugador;

    @BeforeEach
    public void setUp(){
        unJugador = new Jugador("Juan");
    }

    @Test
    public void test01CreoUnMultiplicadorLoAplicoYLosPuntosSeDuplican(){
         int unFactor = 2;
        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        PuntajePenalizable unPuntaje = new PuntajePenalizable();

        Resultado unResultado = unPuntaje.obtenerResultado(2,unJugador);
        Resultado otroResultado = unPuntaje.obtenerResultado(2,unJugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        unMultiplicador.aplicar(unResultado,otroResultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(4,puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnMultiplicadorLoAplicoYLosPuntosSeTriplican(){
        int unFactor = 3;
        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        PuntajePenalizable unPuntaje = new PuntajePenalizable();

        Resultado unResultado = unPuntaje.obtenerResultado(2,unJugador);
        Resultado otroResultado = unPuntaje.obtenerResultado(2,unJugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        unMultiplicador.aplicar(unResultado,otroResultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(6,puntosRepresentados.representar());
    }

    @Test
    public void test03CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeTriplican(){
        int unFactor = 3;
        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoPositivo());
        }

        puntos = unMultiplicador.usarEnPuntos(puntos,unJugador);

        assertEquals(30,puntos.representar());
    }

    @Test
    public void test04CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeDuplican(){
        int unFactor = 2;
        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        Puntuacion puntos = new Puntuacion();
        for (int i=0;i<10;i++) {
            puntos.agregarPunto(new PuntoNegativo());
        }

        puntos = unMultiplicador.usarEnPuntos(puntos,unJugador);

        assertEquals(-20,puntos.representar());
    }
    @Test
    public void test05CreoUnMultiplicadorLoAplicoEnUnResultadoIncorrectoSuValorSigueSiendoCeroPuntos(){
        int unFactor = 3;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        Resultado unResultado = unPuntaje.obtenerResultado(2,unJugador);
        Resultado otroResultado = unPuntaje.obtenerResultado(2,unJugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();

        unMultiplicador.aplicar(unResultado,otroResultado);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

}
