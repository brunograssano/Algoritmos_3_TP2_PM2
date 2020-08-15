package edu.fiuba.algo3.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import java.io.File;
import java.net.URI;

public class ControladorReproductorMusica {

    private AudioClip temaEscuchandose;

    public ControladorReproductorMusica(){
        String direccion = "\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\musica\\classic.mp3";
        temaEscuchandose = reproducirTema(direccion);
    }

    public void escucharTema(String direccion) {
        if(temaEscuchandose.isPlaying()){
            temaEscuchandose.stop();
        }
        if(!direccion.isEmpty()){
            temaEscuchandose = reproducirTema(direccion);
        }
    }

    private AudioClip reproducirTema(String direccion){
        // TODO ver bien como hacer que tome la direccion a la musica
        File dir = new File(System.getProperty("user.dir") + direccion);
        URI path = dir.toURI();
        String direccionParaMedia = path.toString();
        Media musica = new Media(direccionParaMedia);
        AudioClip mediaPlayer = new AudioClip(musica.getSource());
        mediaPlayer.play();
        mediaPlayer.setVolume(5);
        return  mediaPlayer;
    }
}
