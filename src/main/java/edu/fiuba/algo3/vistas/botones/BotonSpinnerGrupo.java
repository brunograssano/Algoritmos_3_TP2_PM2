package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.opciones.Opcion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class BotonSpinnerGrupo{


    public BotonSpinnerGrupo(Opcion opcion, ControladorEnviarGroupChoice controlador) {

        Label label = new Label(opcion.obtenerTexto());

        ObservableList<String> nombresGruposPosibles = FXCollections.observableArrayList(//
                "January", "February", "March", "April", //
                "May", "June", "July", "August", //
                "September", "October", "November", "December");

        final Spinner<String> spinner = new Spinner<String>();

        // Value factory.
        SpinnerValueFactory<String> valueFactory = //
                new SpinnerValueFactory.ListSpinnerValueFactory<String>(nombresGruposPosibles);

        // Default value
        valueFactory.setValue("February");

        spinner.setValueFactory(valueFactory);

        FlowPane root = new FlowPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(10));

        root.getChildren().addAll(label, spinner);

    }
}
