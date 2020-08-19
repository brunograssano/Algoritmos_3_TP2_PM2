package edu.fiuba.algo3.controladores;

import edu.fiuba.algo3.Excepciones.ArchivoNoEncontradoException;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.desordenador.CriterioDesorden;
import edu.fiuba.algo3.vistas.ContenedorPrincipal;
import edu.fiuba.algo3.vistas.VistaTransicionPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class ControladorNombresJugadores implements EventHandler<ActionEvent> {

    private Stage stage;
    private TextField textoJugador1;
    private TextField textoJugador2;
    private ContenedorPrincipal contenedorPrincipal;

    public ControladorNombresJugadores(Stage stage, TextField textoJugador1, TextField textoJugador2, ContenedorPrincipal contenedorPrincipal){
        this.stage = stage;
        this.textoJugador1 = textoJugador1;
        this.textoJugador2 = textoJugador2;
        this.contenedorPrincipal = contenedorPrincipal;
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
            try{
            AlgoHoot.getInstance().agregarJugadores(nombreJugador1,nombreJugador2,new CriterioDesorden());
            }
            catch(ArchivoNoEncontradoException ex) {
                ex.printStackTrace();
                Alert archivoNoEncontrado = new Alert(Alert.AlertType.ERROR);
                archivoNoEncontrado.setHeaderText("Archivo no Encontrado");
                archivoNoEncontrado.setContentText("Por favor revise que existe el archivo \n" + System.getProperty("user.dir") + ex.getMessage() + "\n y tiene el formato correcto");
                archivoNoEncontrado.show();
            }
            contenedorPrincipal.setCentro(new VistaTransicionPregunta(stage,contenedorPrincipal));
        }
    }

}
