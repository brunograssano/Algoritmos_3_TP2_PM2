package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.controladores.ControladorEnviarOrderedChoice;
import edu.fiuba.algo3.modelo.preguntas.OpcionSimple;
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

public class OpcionOrderedChoice extends HBox {

    private final static String AMARILLO = "FBD87F";
    private final static int PRIMER_POSICION = 1;
    private final static int VALOR_INICIAL_SPINNER = 1;
    private Label label;
    private Spinner<Integer> spinner;

    public OpcionOrderedChoice(OpcionSimple opcion, int cantidadOpciones, ControladorEnviarOrderedChoice controlador){

        Background unFondito = new Background(new BackgroundFill(Color.web(AMARILLO), new CornerRadii(0), new Insets(1)));
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(PRIMER_POSICION, cantidadOpciones, VALOR_INICIAL_SPINNER);

        Spinner<Integer> spinner = new Spinner<>();
        spinner.setValueFactory(valueFactory);
        spinner.setBackground(unFondito);
        spinner.setMaxWidth(50);
        spinner.setMaxHeight(50);
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_ARROWS_ON_LEFT_VERTICAL);

        Label label = new Label(opcion.obtenerTexto());
        label.setBackground(unFondito);
        label.setFont(Font.font("montserrat", 25));
        label.setTextFill(Color.BLACK);
        this.label = label;
        this.spinner = spinner;
        super.setAlignment(Pos.CENTER);
        super.setSpacing(2);
        super.getChildren().addAll(spinner, label);
    }
    public int getNumeroOrden(){
        return spinner.getValue();
    }
    public String getEnunciadoOpcion(){
        return label.getText();
    }
}
