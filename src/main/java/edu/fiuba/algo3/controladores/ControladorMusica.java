package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URI;


public class ControladorMusica implements EventHandler<ActionEvent> {

    private String direccion;
    private ControladorReproductorMusica reproductor;
    public ControladorMusica(String direccionMusica,ControladorReproductorMusica unReproductor) {
        direccion = direccionMusica;
        reproductor = unReproductor;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        reproductor.escucharTema(direccion);
    }
}
