package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorIniciarJuego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VistaInicio extends StackPane{
    static String VIOLETA = "9370DB";
    static String GRIS = "D8DDEF";
    static String VERDE = "33FF96";
    static String AZUL = "0083E0";
    static String ROJO = "EF2D56";
    static String AMARILLO = "FBD87F";

    private Stage stage;

    public VistaInicio(Stage stagePrincipal) {
        super();
        this.stage = stagePrincipal;

        Background fonditoGris = new Background(new BackgroundFill(Color.web(GRIS), CornerRadii.EMPTY, Insets.EMPTY));
        super.setBackground(fonditoGris);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.CENTER);

        Label label = new Label("AlgoHoot");
        label.setFont(Font.font("comic sans ms",80));
        label.setTextFill(Color.web(VIOLETA));
        cajaPrincipal.getChildren().add(label);

        ToggleButton button = new ToggleButton();
        button.setText("Iniciar partida");
        button.setFont(Font.font("comic sans ms", 20));
        button.setTextFill(Color.web(GRIS));
        button.setOnAction(new ControladorIniciarJuego(stagePrincipal));
        Background unFondito = new Background(new BackgroundFill(Color.web(VIOLETA), new CornerRadii(9), new Insets(1)));
        button.setBackground(unFondito);
        cajaPrincipal.getChildren().add(button);


        super.getChildren().add(cajaPrincipal);
    }

   /* public void GenerarPantalla(Stage stage) {


        StackPane layout = new StackPane();
        Background fonditoGris = new Background(new BackgroundFill(Color.web(GRIS), CornerRadii.EMPTY, Insets.EMPTY));
        layout.setBackground(fonditoGris);

        VBox cajaPrincipal = new VBox(70);
        cajaPrincipal.setAlignment(Pos.CENTER);

        Label label = new Label("AlgoHoot");
        label.setFont(Font.font("comic sans ms",80));
        label.setTextFill(Color.web(VIOLETA));
        cajaPrincipal.getChildren().add(label);


        ToggleButton button = new ToggleButton();
        button.setText("Iniciar partida :^)");
        button.setFont(Font.font("comic sans ms", 20));
        button.setTextFill(Color.web(GRIS));
        Background unFondito = new Background(new BackgroundFill(Color.web(VIOLETA), new CornerRadii(9), new Insets(1)));
        button.setBackground(unFondito);
        cajaPrincipal.getChildren().add(button);


        layout.getChildren().add(cajaPrincipal);

        var scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.show();
    }*/

}
