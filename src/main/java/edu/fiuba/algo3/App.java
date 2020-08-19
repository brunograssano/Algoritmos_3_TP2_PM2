package edu.fiuba.algo3;

import edu.fiuba.algo3.controladores.ControladorTeclaPresionada;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
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
    public void start(Stage stage) {
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage);
        contenedorPrincipal.setCentro(new VistaInicio(stage,contenedorPrincipal));

        Scene sceneInicio = new Scene(contenedorPrincipal,1280, 720);
        sceneInicio.setOnKeyPressed(new ControladorTeclaPresionada(stage, contenedorPrincipal.getBarraDeMenu()));

        Image icono = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/Icono.png");
        stage.getIcons().add(icono);
        stage.setScene(sceneInicio);
        stage.setMinWidth(1280);
        stage.setMinHeight(720);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}