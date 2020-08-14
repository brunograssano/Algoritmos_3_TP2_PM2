package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stagePrincipal) {

        VistaInicio vistaInicio = new VistaInicio(stagePrincipal);
        Scene sceneInicio = new Scene(vistaInicio,800,600);

        Image icono = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/Icono.png");
        stagePrincipal.getIcons().add(icono);
        stagePrincipal.setScene(sceneInicio);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}