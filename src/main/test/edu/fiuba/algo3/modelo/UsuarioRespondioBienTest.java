package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.resultados.ResultadoParcial;
import edu.fiuba.algo3.modelo.puntos.PuntuacionRepresentable;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioRespondioBienTest {

    Jugador jugador;

    public void setUp(){
        jugador = new Jugador("Prueba");
    }

    @Test
    public void test01CreoUnUsuarioRespondioBienAlGanarExclusividadSeDuplicanLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);

        unaSituacion.ganoExclusividad();

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(6,puntosRepresentados.representar());
    }

    @Test
    public void test02CreoUnUsuarioRespondioBienAlPerderPuntuacionSePierdenLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);

        unaSituacion.pierdoPuntuacion();

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

    @Test
    public void test03CreoUnUsuarioRespondioBienLoComparoConUnoQueSeEquivocoEntoncesSeDuplicanLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(6,puntosRepresentados.representar());
    }

    @Test
    public void test04CreoUnUsuarioRespondioBienLoComparoConUnoQueRespondioBienEntoncesPierdoLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial(jugador);
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial(jugador);
        otroResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioRespondioBien otraSituacion = new UsuarioRespondioBien(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        PuntuacionRepresentable puntosRepresentados = new PuntuacionRepresentable();
        unResultado.obtenerPuntos().valorNumerico(puntosRepresentados);

        assertEquals(0,puntosRepresentados.representar());
    }

}
