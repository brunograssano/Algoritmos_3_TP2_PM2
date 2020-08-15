package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.net.URI;


public class ControladorMusica implements EventHandler<ActionEvent> {

    private String direccion;
    public ControladorMusica(String direccionMusica) {
        direccion = direccionMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // TODO ver bien como hacer que tome la direccion a la musica
        File dir = new File(System.getProperty("user.dir") + direccion);
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.play();
        mediaPlayer.setVolume(5);
    }
}
