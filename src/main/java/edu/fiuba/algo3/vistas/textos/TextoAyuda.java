package edu.fiuba.algo3.vistas.textos;

import edu.fiuba.algo3.vistas.seccionesVista.estetica.EstilosApp;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoAyuda extends Label {
    public TextoAyuda(){
        super("El juego consiste en responder diferentes tipos de preguntas, y conseguir la mayor cantidad posible de puntos\n\n" +
                "Existen 4 tipos distintos de preguntas, verdadero falso, multiple choice, orden y grupos. \n\n" +
                "Tambien hay distintos tipos de puntaje, estos son clasico, parcial, y penalizable. \n" +
                "\t - Clasico: Se deben de responder correctamente todas las respuestas correctas para tener un punto.\n" +
                "\t - Parcial: (solo multiple choice) Se obtiene un punto por cada respuesta correcta, \n" +
                "\t\t\to 0 puntos en el caso de tener al menos una incorrecta.\n" +
                "\t - Penalizable: Se obtiene un punto por cada respuesta correcta y menos un punto por cada incorrecta.\n\n" +
                "Por ultimo, hay que tener en cuenta los modificadores, cada jugador posee dos multiplicadores, un x2 y un x3 " +
                "para usar en las preguntas penalizables y tambien  dos exclusividades, que al usarla otorgan el doble de puntos " +
                "si solo un jugador respondio correctamente. (en preguntas con puntaje clasico y parcial)");
        super.setFont(Font.font(EstilosApp.FUENTE,18));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }

}
