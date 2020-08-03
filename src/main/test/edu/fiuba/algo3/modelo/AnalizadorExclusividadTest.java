package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.modificadores.AnalizadorExclusividad;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalizadorExclusividadTest {

    @Test
    public void test01CreoUnAnalizadorDeExclusividadAmbosUsuariosRespondenBienNingunoSumaPuntos(){

        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial();

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial();

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
        puntosJugadores.add(unResultado.obtenerPuntos().valorNumerico());
        puntosJugadores.add(otroResultado.obtenerPuntos().valorNumerico());

        assertEquals(puntosEsperados,puntosJugadores);
    }
    @Test
    public void test02CreoUnAnalizadorDeExclusividadAmbosUsuariosRespondenMalNingunoSumaPuntos(){

        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial();

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaIncorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial();

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
        puntosJugadores.add(unResultado.obtenerPuntos().valorNumerico());
        puntosJugadores.add(otroResultado.obtenerPuntos().valorNumerico());

        assertEquals(puntosEsperados,puntosJugadores);
    }
    @Test
    public void test03CreoUnAnalizadorDeExclusividadUnoRespondeBienElOtroMalEntoncesElQueRespondeBienDuplicaPuntos(){

        AnalizadorExclusividad unAnalizador = new AnalizadorExclusividad();

        ResultadoParcial unResultado = new ResultadoParcial();

        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        ResultadoParcial otroResultado = new ResultadoParcial();

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
        puntosJugadores.add(unResultado.obtenerPuntos().valorNumerico());
        puntosJugadores.add(otroResultado.obtenerPuntos().valorNumerico());

        assertEquals(puntosEsperados,puntosJugadores);
    }
}
