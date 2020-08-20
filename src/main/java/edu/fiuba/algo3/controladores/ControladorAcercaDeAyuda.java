package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class ControladorAcercaDeAyuda implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("Acerca de la aplicacion");
        String mensaje = "Aplicacion estilo Kahoot creada para el TP2 de la materia Algoritmos y programacion 3 por el grupo PM2 \n Integrantes: \n\t\t\t* Joaquin Gomez \n\t\t\t* Bruno Grassano \n\t\t\t* Guillermo Stancanelli\n\t\t\t* Juan Cruz Roussilian";
        alert.setContentText(mensaje);
        alert.show();
    }
}
