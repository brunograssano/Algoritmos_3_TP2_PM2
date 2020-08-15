package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.ModificadorNoAptoParaPreguntaException;
import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeParcial;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalizable;
import edu.fiuba.algo3.modelo.puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.puntos.PuntoPositivo;
import edu.fiuba.algo3.modelo.puntos.Puntuacion;
import edu.fiuba.algo3.modelo.preguntas.resultados.Resultado;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MultiplicadorJugadorTest {

    @Test
    public void test01AlIntentarAplicarUnMultiplicadorAUnPuntajeClasicoSeDebeLanzarExcepcion(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        modificadoresDeLaJugada.add(unMultiplicador);

        PuntajeClasico unPuntaje = new PuntajeClasico();

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{
                    unMultiplicador.usarEnPuntaje(unPuntaje,modificadoresDeLaJugada);}
        );
    }

    @Test
    public void test02AlIntentarAplicarUnMultiplicadorAUnPuntajeParcialSeDebeLanzarExcepcion(){

        Jugador unJugador = new Jugador("Juan");

        int unFactor = 2;

        MultiplicadorJugador unMultiplicador = new MultiplicadorJugador(unJugador,unFactor);

        ArrayList<Modificador> modificadoresDeLaJugada = new ArrayList();

        PuntajeParcial unPuntaje = new PuntajeParcial();

        assertThrows(ModificadorNoAptoParaPreguntaException.class,
                ()->{
                    unMultiplicador.usarEnPuntaje(unPuntaje,modificadoresDeLaJugada);}
        );
    }

    @Test
    public void test03CreoUnMultiplicadorLoAplicoEnUnPuntajePenalizableYLosPuntosSeDuplican(){

        Jugador unJugador = new Jugador("Juan");

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
    public void test04CreoUnMultiplicadorLoAplicoEnUnPuntajePenalizableYLosPuntosSeTriplican(){

        Jugador unJugador = new Jugador("Juan");

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
    public void test05CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeTriplican(){

        Jugador unJugador = new Jugador("Juan");

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
    public void test06CreoUnMultiplicadorLoAplicoEnUnaPuntuacionYLosPuntosSeDuplican(){

        Jugador unJugador = new Jugador("Juan");

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
    public void test07CreoUnMultiplicadorLoAplicoEnUnResultadoIncorrectoSuValorSigueSiendoCeroPuntos(){

        Jugador unJugador = new Jugador("Juan");

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
