package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.Excepciones.CantidadDeSituacionesExclusividadErroneaException;
import edu.fiuba.algo3.modelo.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.modificadores.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnalizadorExclusividadTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }

    @Test
    public void test01CreoUnAnalizadorDeExclusividadAmbosUsuariosRespondenBienNingunoSumaPuntos(){
        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial(jugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);

        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioRespondioBien otraSituacion = new UsuarioRespondioBien(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

        unAnalizador.analizarSituacion();

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }
    @Test
    public void test02CreoUnAnalizadorDeExclusividadAmbosUsuariosRespondenMalNingunoSumaPuntos(){
        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial(jugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);

        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioSeEquivoco unaSituacion = new UsuarioSeEquivoco(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

        unAnalizador.analizarSituacion();

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }
    @Test
    public void test03CreoUnAnalizadorDeExclusividadUnoRespondeBienElOtroMalEntoncesElQueRespondeBienDuplicaPuntos(){
        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial(jugador);

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);

        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaCorrecta();
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(6);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

        unAnalizador.analizarSituacion();

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }
    @Test
    public void test04CreoUnAnalizadorDeExclusividadYIntentoAnalizarSinSituacionesLanzaExcepcion(){
        AnalizadorExclusividad analizador = new AnalizadorExclusividad();
        assertThrows(CantidadDeSituacionesExclusividadErroneaException.class,
                ()->{
                    analizador.analizarSituacion();}
        );
    }
}
