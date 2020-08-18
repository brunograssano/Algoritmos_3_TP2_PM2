package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.controladores.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class BarraDeMenu extends MenuBar {

    private String rutaMusica = "\\src\\main\\java\\edu\\fiuba\\algo3\\resources\\musica\\";

    MenuItem opcionPantallaCompleta = new MenuItem("Pantalla completa");

    public BarraDeMenu(Stage stage) {
        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");
        Menu menuMusica = new Menu("Música");
        Menu menuAyuda = new Menu("Ayuda");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");
        MenuItem opcionAyudaJuego = new MenuItem("Ayuda juego");

        opcionSalir.setOnAction(new ControladorTerminarJuego());
        opcionAcercaDe.setOnAction(new ControladorAcercaDeAyuda());
        opcionAyudaJuego.setOnAction(new ControladorAyudaDelJuego());
        opcionPantallaCompleta.setOnAction(new ControladorOpcionPantallaCompleta(stage,opcionPantallaCompleta));

        agregarMusicas(menuMusica);

        menuArchivo.getItems().addAll(opcionSalir);

        menuAyuda.getItems().addAll(opcionAcercaDe,opcionAyudaJuego);
        menuVer.getItems().addAll(opcionPantallaCompleta);

        this.getMenus().addAll(menuArchivo, menuVer, menuMusica, menuAyuda);
    }

    public void aplicacionMaximizada() {
        opcionPantallaCompleta.setDisable(false);
    }

    private void agregarMusicas(Menu menuMusica){
        ReproductorMusica unReproductor = new ReproductorMusica();
        MenuItem opcionSinMusica = new MenuItem("Sin música");
        MenuItem opcionMusicaComun = new MenuItem("Música Kahoot original");
        MenuItem opcionMusicaTrance = new MenuItem("Música Kahoot Trance");
        MenuItem opcionMusicaHalloween = new MenuItem("Música Kahoot Halloween");
        MenuItem opcionMusica8bits = new MenuItem("Música Kahoot 8 Bits");
        MenuItem opcionMusicaTrap = new MenuItem("Música Kahoot Trap");
        MenuItem opcionMusicaDisco = new MenuItem("Música Kahoot Disco");
        MenuItem opcionMusicaFantasy = new MenuItem("Música Kahoot Fantasy");
        MenuItem opcionMusicaReggae = new MenuItem("Música Kahoot Reggae");
        MenuItem opcionMusicaSpace = new MenuItem("Música Kahoot Space");
        MenuItem opcionMusicaDivertida = new MenuItem("Música Kahoot Divertida :)");

        opcionSinMusica.setOnAction(new ControladorMusica("",unReproductor));
        opcionMusicaComun.setOnAction(new ControladorMusica(rutaMusica+"classic.mp3",unReproductor));
        opcionMusicaTrance.setOnAction(new ControladorMusica(rutaMusica+"trance.mp3",unReproductor));
        opcionMusicaHalloween.setOnAction(new ControladorMusica(rutaMusica+"halloween.mp3",unReproductor));
        opcionMusica8bits.setOnAction(new ControladorMusica(rutaMusica+"8bits.mp3",unReproductor));
        opcionMusicaTrap.setOnAction(new ControladorMusica(rutaMusica+"trap.mp3",unReproductor));
        opcionMusicaDisco.setOnAction(new ControladorMusica(rutaMusica+"disco.mp3",unReproductor));
        opcionMusicaFantasy.setOnAction(new ControladorMusica(rutaMusica+"fantasy.mp3",unReproductor));
        opcionMusicaReggae.setOnAction(new ControladorMusica(rutaMusica+"reggae.mp3",unReproductor));
        opcionMusicaSpace.setOnAction(new ControladorMusica(rutaMusica+"space.mp3",unReproductor));
        opcionMusicaDivertida.setOnAction(new ControladorMusica(rutaMusica+"earrape.mp3",unReproductor));

        menuMusica.getItems().addAll(opcionSinMusica,opcionMusicaComun,opcionMusicaTrance,opcionMusicaHalloween,opcionMusica8bits);
        menuMusica.getItems().addAll(opcionMusicaTrap,opcionMusicaDisco,opcionMusicaFantasy,opcionMusicaReggae,opcionMusicaSpace,opcionMusicaDivertida);
       
    }

}
