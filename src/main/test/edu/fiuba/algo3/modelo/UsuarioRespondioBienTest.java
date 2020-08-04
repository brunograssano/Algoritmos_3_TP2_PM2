package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioRespondioBien;
import edu.fiuba.algo3.modelo.preguntas.modificadores.UsuarioSeEquivoco;
import edu.fiuba.algo3.modelo.preguntas.resultados.ResultadoParcial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioRespondioBienTest {

    @Test
    public void test01CreoUnUsuarioRespondioBienAlGanarExclusividadSeDuplicanLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);

        unaSituacion.ganoExclusividad();

        assertEquals(6,unResultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test02CreoUnUsuarioRespondioBienAlPerderPuntuacionSePierdenLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);

        unaSituacion.pierdoPuntuacion();

        assertEquals(0,unResultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test03CreoUnUsuarioRespondioBienLoComparoConUnoQueSeEquivocoEntoncesSeDuplicanLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial();
        otroResultado.sumarRespuestaIncorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioSeEquivoco otraSituacion = new UsuarioSeEquivoco(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        assertEquals(6,unResultado.obtenerPuntos().valorNumerico());
    }

    @Test
    public void test04CreoUnUsuarioRespondioBienLoComparoConUnoQueRespondioBienEntoncesPierdoLosPuntos(){

        ResultadoParcial unResultado = new ResultadoParcial();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        unResultado.sumarRespuestaCorrecta();
        ResultadoParcial otroResultado = new ResultadoParcial();
        otroResultado.sumarRespuestaCorrecta();

        UsuarioRespondioBien unaSituacion = new UsuarioRespondioBien(unResultado);
        UsuarioRespondioBien otraSituacion = new UsuarioRespondioBien(otroResultado);

        unaSituacion.compararCon(otraSituacion);

        assertEquals(0,unResultado.obtenerPuntos().valorNumerico());
    }

}
