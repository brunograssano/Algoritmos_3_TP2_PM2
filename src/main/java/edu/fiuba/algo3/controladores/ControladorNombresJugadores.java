package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Jugada;
import edu.fiuba.algo3.vistas.VistaPedirNombres;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControladorNombresJugadores implements EventHandler<ActionEvent> {

    private Stage stage;
    private TextField textoJugador1;
    private TextField textoJugador2;

    public ControladorNombresJugadores(Stage stage, TextField textoJugador1,TextField textoJugador2){
        this.stage = stage;
        this.textoJugador1 = textoJugador1;
        this.textoJugador2 = textoJugador2;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        String nombreJugador1 = textoJugador1.getText();
        String nombreJugador2 = textoJugador2.getText();
        if(nombreJugador1.isEmpty() || nombreJugador2.isEmpty()){
            Alert nombresSinCompletar = new Alert(Alert.AlertType.ERROR);
            nombresSinCompletar.setHeaderText("No completo los dos nombres");
            nombresSinCompletar.setContentText("Los dos jugadores deben de tener un nombre!");
            nombresSinCompletar.show();
        }
        else{
            AlgoHoot.getInstance().agregarJugadores(nombreJugador1,nombreJugador2);
            VistaTransicionPregunta vistaTransicion = new VistaTransicionPregunta(stage);
            Scene scene = new Scene(vistaTransicion,800,600);
            stage.setScene(scene);
        }
    }

}
