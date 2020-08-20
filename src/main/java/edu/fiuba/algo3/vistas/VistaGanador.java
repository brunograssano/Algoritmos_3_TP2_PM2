package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.controladores.ControladorReiniciarJuego;
import edu.fiuba.algo3.controladores.ControladorTerminarJuego;
import edu.fiuba.algo3.modelo.AlgoHoot;
import edu.fiuba.algo3.modelo.Empate;
import edu.fiuba.algo3.modelo.Ganador;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.vistas.botones.BotonReiniciarJuego;
import edu.fiuba.algo3.vistas.botones.BotonTerminarJuego;
import edu.fiuba.algo3.vistas.seccionesVista.GrillaGanador;
import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import edu.fiuba.algo3.vistas.textos.AlgoHootPrincipal;
import edu.fiuba.algo3.vistas.textos.TextoJugador;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class VistaGanador extends StackPane {

    private final Stage stage;
    //   private final ArrayList<MovingDot> puntitos;
    //   private final Random randomizador = new Random();

    public VistaGanador(Stage stage, ContenedorPrincipal contenedorPrincipal) {

        this.stage = stage;
//        puntitos = new ArrayList<>();

        Image imagenfondo = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/fondoInicio.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(imagenfondo, null, null, BackgroundPosition.CENTER, null);
        Background fondo = new Background(fondoImagen);
        super.setBackground(fondo);


        Image imagenPapelPicado = new Image("file:" + System.getProperty("user.dir") + "/src/main/java/edu/fiuba/algo3/resources/imagenes/papelpicado.gif");
        ImageView imageviewpapel = new ImageView(imagenPapelPicado);
        imageviewpapel.setFitHeight(720);
        imageviewpapel.setFitWidth(1280);
        super.getChildren().add(imageviewpapel);

        GrillaGanador grilla = new GrillaGanador(1280, 720);
        grilla.setAlignment(Pos.CENTER);

        VBox cajaLogo = new VBox();
        cajaLogo.setAlignment(Pos.CENTER);
        AlgoHootPrincipal textoAlgoHootInicio = new AlgoHootPrincipal(EstilosApp.GRIS);

        cajaLogo.getChildren().add(textoAlgoHootInicio);

        VBox cajaGanador = new VBox();
        cajaGanador.setAlignment(Pos.CENTER);
        cajaGanador.setPadding(new Insets(90, 0, 0, 0));

        Ganador ganador = AlgoHoot.getInstance().obtenerGanador();
        armarTextoGanador(cajaGanador, ganador);

        VBox cajaInferior = new VBox(30);
        cajaInferior.setAlignment(Pos.CENTER);

        BotonReiniciarJuego botonReiniciarJuego = new BotonReiniciarJuego(new ControladorReiniciarJuego(stage, contenedorPrincipal));
        cajaInferior.getChildren().add(botonReiniciarJuego);

        BotonTerminarJuego botonTerminarJuego = new BotonTerminarJuego(new ControladorTerminarJuego());
        cajaInferior.getChildren().add(botonTerminarJuego);

        grilla.add(cajaLogo, 0, 0);
        grilla.add(cajaGanador, 0, 1);
        grilla.add(cajaInferior, 0, 2);
        super.getChildren().add(grilla);
    }


    private void armarTextoGanador(VBox cajaGanador, Ganador ganador){

        if(ganador instanceof Empate){
            Label textoGanador = new Label();
            textoGanador.setTextFill(Color.web(EstilosApp.GRIS));
            textoGanador.setText("Empate! Ambos jugadores son muy inteligentes");
            textoGanador.setFont(Font.font(EstilosApp.FUENTE,40));
            cajaGanador.getChildren().add(textoGanador);
        }else if(ganador instanceof Jugador){
            TextFlow flow = new TextFlow();

            Text elGanadorEs =new Text("El Ganador es ");
            elGanadorEs.setStyle("-fx-font-weight: regular");

            elGanadorEs.setFont(Font.font(EstilosApp.FUENTE,60));

            Text con =new Text(" con ");
            elGanadorEs.setStyle("-fx-font-weight: regular");

            con.setFont(Font.font(EstilosApp.FUENTE,60));

            Text nombreGanador=new Text(ganador.obtenerNombre());
            nombreGanador.setStyle("-fx-font-weight: bold");
            nombreGanador.setFont(Font.font(EstilosApp.FUENTE,80));

            if(ganador.obtenerNombre().equals(AlgoHoot.getInstance().obtenerJugador1().obtenerNombre())){
                nombreGanador.setFill(Color.RED);
            }
            else{
                nombreGanador.setFill(Color.BLUE);
            }

            Text puntosGanador=new Text(""+ ganador.obtenerPuntos());
            puntosGanador.setStyle("-fx-font-weight: bold");
            puntosGanador.setFont(Font.font(EstilosApp.FUENTE,80));

            Text puntos =new Text();
            elGanadorEs.setStyle("-fx-font-weight: regular");

            puntos.setFont(Font.font(EstilosApp.FUENTE,60));

            if (Math.abs(ganador.obtenerPuntos()) != 1) {
                puntos.setText("puntos.");
            } else {
                puntos.setText("punto.");
            }


            flow.getChildren().addAll(elGanadorEs, nombreGanador, con, puntosGanador, puntos);
            flow.setTextAlignment(TextAlignment.CENTER);
            cajaGanador.getChildren().add(flow);
        }
    }






}
