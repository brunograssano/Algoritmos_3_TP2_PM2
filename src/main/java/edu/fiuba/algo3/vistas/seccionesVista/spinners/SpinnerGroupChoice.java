package edu.fiuba.algo3.vistas.seccionesVista.spinners;

import edu.fiuba.algo3.controladores.ControladorEnviarGroupChoice;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import java.util.ArrayList;

public class SpinnerGroupChoice extends HBox {

    private final OpcionSimple opcionSpinner;
    private final Spinner<String> spinner;

    public SpinnerGroupChoice(ArrayList<String> nombresGrupos, OpcionSimple opcion, ControladorEnviarGroupChoice controlador) {


        ObservableList<String> nombresGruposPosibles = FXCollections.observableArrayList();
        nombresGruposPosibles.addAll(nombresGrupos);

        spinner = new Spinner<>();
        opcionSpinner = opcion;

        SpinnerValueFactory<String> valueFactory = new SpinnerValueFactory.ListSpinnerValueFactory<>(nombresGruposPosibles);
        valueFactory.setValue(nombresGruposPosibles.get(0)); //valor por defecto
        spinner.setValueFactory(valueFactory);
        spinner.setMaxWidth(350);
        spinner.setMaxHeight(50);
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        Label label = new Label(opcion.obtenerTexto());
        label.setFont(Font.font(EstilosApp.FUENTE, 20));
        label.setTextFill(Color.BLACK);

        Insets padding = new Insets(4,4,4,4);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color colorTransparente = Color.web(EstilosApp.GRIS,EstilosApp.ALPHA_OPCIONES);
        spinner.setBackground(new Background(new BackgroundFill(colorTransparente,bordeRedondeado,null)));
        spinner.setPadding(padding);
        label.setBackground(new Background(new BackgroundFill(colorTransparente,bordeRedondeado,null)));
        label.setPadding(padding);

        super.setAlignment(Pos.CENTER);
        super.setSpacing(2);
        super.getChildren().addAll(spinner, label);
    }

    public String getGrupoOpcion(){
        return spinner.getValue();
    }

    public OpcionSimple getOpcionSpinner() { return opcionSpinner;}
}
