package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.FabricaDeVistas;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorSiguientePregunta implements EventHandler<ActionEvent> {

    private Stage stage;
    private ContenedorPrincipal contenedorPrincipal;

    public ControladorSiguientePregunta(Stage stage, ContenedorPrincipal contenedorPrincipal) {
        this.stage = stage;
        this.contenedorPrincipal = contenedorPrincipal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Pregunta pregunta = AlgoHoot.getInstance().pedirPreguntaActual();
        contenedorPrincipal.setCentro(FabricaDeVistas.CrearVistaDePregunta(pregunta, stage, contenedorPrincipal));
    }

}
