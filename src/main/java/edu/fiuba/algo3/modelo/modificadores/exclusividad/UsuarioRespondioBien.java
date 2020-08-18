package edu.fiuba.algo3.modelo.modificadores.exclusividad;

import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorExclusividad;
import edu.fiuba.algo3.modelo.resultados.Resultado;

public class UsuarioRespondioBien implements SituacionesExclusividad {
    Resultado resultadoDelJugador;
    public UsuarioRespondioBien(Resultado resultado) {
        resultadoDelJugador = resultado;
    }

    @Override
    public void compararCon(UsuarioRespondioBien situacionDelRival) {
        pierdoPuntuacion();
        situacionDelRival.pierdoPuntuacion();
    }

    @Override
    public void compararCon(UsuarioSeEquivoco situacionDelRival) {
        ganoExclusividad();
    }

    @Override
    public void compararCon(SituacionesExclusividad situacion) {
        situacion.compararCon(this);
    }

    public void pierdoPuntuacion(){
        resultadoDelJugador.sumarRespuestaIncorrecta();
    }

    public void ganoExclusividad() {
        resultadoDelJugador.aplicarMultiplicador(new MultiplicadorExclusividad());
    }
}
