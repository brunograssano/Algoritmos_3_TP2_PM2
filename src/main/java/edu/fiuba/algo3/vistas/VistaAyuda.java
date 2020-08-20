package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import edu.fiuba.algo3.vistas.textos.TextoAyuda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VistaAyuda extends StackPane {
    public VistaAyuda() {
        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setPadding(new Insets(20));
        cajaPrincipal.setAlignment(Pos.CENTER);

        Label titulo = new Label("Ayuda sobre el juego");
        titulo.setFont(Font.font(EstilosApp.FUENTE,25));
        titulo.setStyle("-fx-font-weight: bold");
        titulo.setUnderline(true);
        titulo.setTextFill(Color.BLACK);
        titulo.setWrapText(true);

        cajaPrincipal.getChildren().add(titulo);
        cajaPrincipal.getChildren().add(new TextoAyuda());

        super.getChildren().add(cajaPrincipal);
    }
}
