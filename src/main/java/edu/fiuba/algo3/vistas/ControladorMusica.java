package edu.fiuba.algo3.vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;



public class ControladorMusica implements EventHandler<ActionEvent> {

    private String direccion;
    public ControladorMusica(String direccionMusica) {
        direccion = direccionMusica;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // TODO ver bien como hacer que tome la direccion a la musica
        String dir = "file:"+System.getProperty("user.dir") + "\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\musica\\classic.mp3";
        Media musica = new Media(dir);
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.play();
        mediaPlayer.setVolume(2);
        mediaPlayer.setAutoPlay(true);
    }
}
