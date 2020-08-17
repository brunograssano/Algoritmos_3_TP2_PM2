package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.exclusividad.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.resultados.Resultado;
import edu.fiuba.algo3.modelo.resultados.ResultadoParcial;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalizadorExclusividadTest {

    Jugador jugador;

    @BeforeEach
    public void setUp(){
        jugador = new Jugador("Prueba");
    }

    private void repetirSumaCorrectas(Resultado unResultado, int repeticiones ){
        for (int i=0;i<repeticiones;i++) {
            unResultado.sumarRespuestaCorrecta();
        }
    }

    @Test
    public void test01CreoUnAnalizadorDeExclusividadAmbosUsuariosRespondenBienNingunoSumaPuntos(){
        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        repetirSumaCorrectas(unResultado, 3);

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        repetirSumaCorrectas(otroResultado, 3);

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioRespondioBien otraSituacion = new UsuarioRespondioBien(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

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

        repetirSumaCorrectas(unResultado, 3);
        unResultado.sumarRespuestaIncorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);

        repetirSumaCorrectas(otroResultado, 3);
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioSeEquivoco unaSituacion = new UsuarioSeEquivoco(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(0);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

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
        repetirSumaCorrectas(unResultado, 3);

        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        repetirSumaCorrectas(otroResultado, 3);
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        ArrayList<Integer> puntosEsperados = new ArrayList<>();
        puntosEsperados.add(6);
        puntosEsperados.add(0);

        unAnalizador.agregarSituacion(unaSituacion);
        unAnalizador.agregarSituacion(otraSituacion);

        ArrayList<Integer> puntosJugadores = new ArrayList<>();
        PuntuacionRepresentable puntosRepresentados1 = new PuntuacionRepresentable();
        PuntuacionRepresentable puntosRepresentados2 = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados1);
        otroResultado.obtenerPuntos().valorNumerico(puntosRepresentados2);

        puntosJugadores.add(puntosRepresentados1.representar());
        puntosJugadores.add(puntosRepresentados2.representar());

        assertEquals(puntosEsperados,puntosJugadores);
    }

}
