package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionEvaluable;
import edu.fiuba.algo3.modelo.preguntas.opciones.OpcionSimple;
import edu.fiuba.algo3.modelo.preguntas.respuestas.RespuestaGroupChoice;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import edu.fiuba.algo3.vistas.botones.BotonSpinnerGrupo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorEnviarGroupChoice implements EventHandler<ActionEvent> {

    private final HashMap<String, ArrayList<OpcionSimple>> respuestasUsuario;
    private final ArrayList<String> nombresGrupo;
    private final Stage stage;

    public ControladorEnviarGroupChoice(ArrayList<String> nombresGrupo, Stage stage) {
        this.nombresGrupo = nombresGrupo;
        respuestasUsuario = new HashMap<>();
        respuestasUsuario.put(nombresGrupo.get(0), new ArrayList<>());
        respuestasUsuario.put(nombresGrupo.get(1), new ArrayList<>());
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        RespuestaGroupChoice respuestaDeUnJugador =  new RespuestaGroupChoice(nombresGrupo.get(0), respuestasUsuario.get(nombresGrupo.get(0)), nombresGrupo.get(1), respuestasUsuario.get(nombresGrupo.get(1)));
        AlgoHoot.getInstance().procesarTurno(respuestaDeUnJugador);
        VistaTransicionPregunta vistaTransicion = new VistaTransicionPregunta(stage);
        Scene scene = new Scene(vistaTransicion,800,600);
        stage.setScene(scene);
    }

    public void agregarOpcionesSeleccionadas(ArrayList<BotonSpinnerGrupo> spinnersGrupo) {
        for(BotonSpinnerGrupo spinner : spinnersGrupo){
           respuestasUsuario.get(spinner.getGrupoOpcion()).add(spinner.getOpcionSpinner());
        }
    }
}
