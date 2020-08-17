package edu.fiuba.algo3.vistas.botones;

import edu.fiuba.algo3.controladores.ControladorEnviarMultipleChoice;
import edu.fiuba.algo3.modelo.preguntas.OpcionEvaluable;
import edu.fiuba.algo3.vistas.EstilosApp;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BotonOpcionMultipleChoice extends CheckBox {

    private OpcionEvaluable opcion;

    public BotonOpcionMultipleChoice(OpcionEvaluable opcion, ControladorEnviarMultipleChoice controladorRespondioUsuario) {
        this.opcion = opcion;
        super.setText(opcion.obtenerTexto());
        super.setFont(Font.font(EstilosApp.FUENTE, 25));
        super.setTextFill(Color.BLACK);
        Insets padding = new Insets(8,8,8,8);
        CornerRadii bordeRedondeado = new CornerRadii(10);
        Color colorTransparente = Color.web(EstilosApp.GRIS,EstilosApp.ALPHA_OPCIONES);
        super.setBackground(new Background(new BackgroundFill(colorTransparente,bordeRedondeado,null)));
        super.setPadding(padding);
        super.selectedProperty().addListener((valorObservado, valorViejo, valorNuevo) -> {
            if(valorNuevo){
                controladorRespondioUsuario.agregarOpcion(opcion);
            }
            else{
                controladorRespondioUsuario.eliminarOpcion(opcion);
            }
        });
    }


}
