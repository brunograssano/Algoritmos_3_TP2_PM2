package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.respuestas.Respuesta;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaGanador;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.stage.Stage;

public abstract class ControladorPreguntasJuego {

    protected Stage stage;
    protected ContenedorPrincipal contenedorPrincipal;

    protected void definirSiguienteVista(Respuesta respuestaDeUnJugador){
        AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
        if(AlgoHoot.getInstance().terminoElJuego()){
            contenedorPrincipal.setCentro(new VistaGanador(stage,contenedorPrincipal));
        }else{
            contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
        }
    }
}
