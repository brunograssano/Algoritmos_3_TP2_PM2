package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.modelo.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaGanador;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import edu.fiuba.algo3.vistas.botones.BotonSpinnerGrupo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorEnviarGroupChoice implements EventHandler<ActionEvent> {

    private final HashMap<String, ArrayList<OpcionSimple>> respuestasUsuario;
    ArrayList<BotonSpinnerGrupo> spinnerGrupos;
    private final ArrayList<String> nombresGrupo;
    private final Stage stage;

    private ContenedorPrincipal contenedorPrincipal;

    public ControladorEnviarGroupChoice(ArrayList<String> nombresGrupo, Stage stage, ContenedorPrincipal contenedorPrincipal) {
        this.nombresGrupo = nombresGrupo;
        respuestasUsuario = new HashMap<>();
        respuestasUsuario.put(nombresGrupo.get(0), new ArrayList<>());
        respuestasUsuario.put(nombresGrupo.get(1), new ArrayList<>());
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        agregarOpcionesSeleccionadas(spinnerGrupos);
        RespuestaGroupChoice respuestaDeUnJugador =  new RespuestaGroupChoice(nombresGrupo.get(0), respuestasUsuario.get(nombresGrupo.get(0)), nombresGrupo.get(1), respuestasUsuario.get(nombresGrupo.get(1)));
        AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
        if(AlgoHoot.getInstance().terminoElJuego()){
            contenedorPrincipal.setCentro(new VistaGanador(stage,contenedorPrincipal));
        }else{
            contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
        }
    }

    public void agregarSpinnersGrupo(ArrayList<BotonSpinnerGrupo> spinnerGrupos){
        this.spinnerGrupos = spinnerGrupos;
    }

    public void agregarOpcionesSeleccionadas(ArrayList<BotonSpinnerGrupo> spinnersGrupo) {
        for(BotonSpinnerGrupo spinner : spinnersGrupo){
           respuestasUsuario.get(spinner.getGrupoOpcion()).add(spinner.getOpcionSpinner());
        }
    }
}
