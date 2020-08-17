package edu.fiuba.algo3.vistas.seccionesVista;

import edu.fiuba.algo3.modelo.modificadores.Modificador;
import edu.fiuba.algo3.modelo.modificadores.exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.Multiplicador;
import edu.fiuba.algo3.modelo.modificadores.multiplicadores.MultiplicadorJugador;
import edu.fiuba.algo3.vistas.PaletaColoresHexa;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class CirculoBonus extends StackPane {
    public CirculoBonus(Modificador modificador) {
        String textoBonus = "";
        if(modificador instanceof Exclusividad){
            textoBonus = "E";
        }
        if(modificador instanceof MultiplicadorJugador){
            Integer factor = ((MultiplicadorJugador) modificador).factor();
            textoBonus = "X"+factor.toString();
        }

        Text textoCirculo = new Text(textoBonus);
        Circle circulo = new Circle(10,Paint.valueOf(PaletaColoresHexa.AMARILLO));
        super.getChildren().addAll(circulo,textoCirculo);

    }
}
