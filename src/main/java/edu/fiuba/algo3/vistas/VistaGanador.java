package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorGanador;
import edu.fiuba.algo3.controladores.ControladorTerminarJuego;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.vistas.botones.BotonEmpezarPregunta;
import edu.fiuba.algo3.vistas.botones.BotonTerminarJuego;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaGanador extends StackPane {

    static String VIOLETA = "9370DB";
    private Stage stage;

    public VistaGanador(Stage stage){

        this.stage = stage;

        Image imagen = new Image("file:"+System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagen,null,null, BackgroundPosition.CENTER,null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);


        VBox cajaPrincipal = new VBox(180);
        cajaPrincipal.setAlignment(Pos.CENTER);

        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(VIOLETA);

        ControladorGanador controladorGanador = new ControladorGanador();
        Label textoGanador = new Label(controladorGanador.obtenerResultadoFinal());
        textoGanador.setFont(Font.font("montserrat",40));
        textoGanador.setTextFill(Color.web(VIOLETA));

        BotonTerminarJuego botonTerminarJuego = new BotonTerminarJuego(new ControladorTerminarJuego());

        cajaPrincipal.getChildren().add(textoAlgoHootInicio);
        cajaPrincipal.getChildren().add(textoGanador);
        cajaPrincipal.getChildren().add(botonTerminarJuego);
        super.getChildren().add(cajaPrincipal);
    }
}
