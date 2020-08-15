package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorAcercaDeAyuda;
import edu.fiuba.algo3.controladores.ControladorAyudaDelJuego;
import edu.fiuba.algo3.controladores.ControladorTerminarJuego;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {
    //MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuMusica = new Menu("Musica");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionAyudaJuego = new MenuItem("Ayuda juego");

        opcionSalir.setOnAction(new ControladorTerminarJuego());
        opcionAcercaDe.setOnAction(new ControladorAcercaDeAyuda());
        opcionAyudaJuego.setOnAction(new ControladorAyudaDelJuego());

        MenuItem opcionSinMusica = new MenuItem("Sin musica");
        MenuItem opcionMusicaComun = new MenuItem("Musica Kahoot original");
        MenuItem opcionMusicaTrance = new MenuItem("Musica Kahoot Trance");

        opcionMusicaComun.setOnAction(new ControladorMusica("\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\musica\\classic.mp3"));
        opcionMusicaTrance.setOnAction(new ControladorMusica("\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\musica\\trance.mp3"));

        menuArchivo.getItems().addAll(opcionSalir);
        menuMusica.getItems().addAll(opcionSinMusica,opcionMusicaComun,opcionMusicaTrance);
        menuAyuda.getItems().addAll(opcionAcercaDe,opcionAyudaJuego);
        //menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuMusica, menuAyuda);
    }

    //public void aplicacionMaximizada() {
    //   opcionPantallaCompleta.setDisable(false);
    //}
}
