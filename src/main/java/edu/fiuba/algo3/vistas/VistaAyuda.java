package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.vistas.textos.TextoAyuda;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class VistaAyuda extends StackPane {
    public VistaAyuda() {
        super();

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.CENTER);

        cajaPrincipal.getChildren().add(new TextoAyuda());

        super.getChildren().add(cajaPrincipal);
    }
}
