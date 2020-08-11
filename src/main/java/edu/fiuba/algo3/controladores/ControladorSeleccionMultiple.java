package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorSeleccionMultiple implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private ControladorEnviarMultipleChoice controladorEnviarRespuesta;

    public ControladorSeleccionMultiple(Opcion opcionAsociada, ControladorEnviarMultipleChoice controladorEnviarRespuesta){
        opcion = opcionAsociada;
        this.controladorEnviarRespuesta = controladorEnviarRespuesta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        //WIP
    }
}
