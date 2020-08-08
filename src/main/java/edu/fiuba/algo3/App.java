package edu.fiuba.algo3;

import edu.fiuba.algo3.vistas.VistaInicio;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stagePrincipal) {

        //llamada a lector
        //crear (singleton) algohoot
        //ponerle las preguntas ---> crea todas las jugadas
        //pedir nombres
        //jugar
        //fin

        VistaInicio vistaInicio = new VistaInicio(stagePrincipal);
        Scene sceneInicio = new Scene(vistaInicio,800,600);

        stagePrincipal.setScene(sceneInicio);
        stagePrincipal.show();
    }

    public static void main(String[] args) {
        launch();
    }

}