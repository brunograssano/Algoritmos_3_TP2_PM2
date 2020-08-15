package edu.fiuba.algo3.vistas.textos;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TextoAyuda extends Label {
    public TextoAyuda(){
        super("El juego consiste en responder diferentes tipos de preguntas, y conseguir la mayor cantidad posible de puntos\n" +
                "Existen 4 tipos distintos de preguntas, verdadero falso, multiple choice, orden y grupos. \n" +
                "Tambien hay distintos tipos de puntaje, estos son clasico, parcial, y penalizable. \n" +
                "Si es clasico, debes de responder correctamente todas las respuestas correctas para tener un punto.\n" +
                "Si es parcial (solo multiple choice) obtenes un punto por cada correcta, 0 si te equivocas.\n" +
                "Si es penalizable tenes un punto por cada correcta y menos un punto por cada incorrecta.\n" +
                "Por ultimo, hay que tener en cuenta los modificadores, tenes dos multiplicadores, un x2 y un x3 " +
                "para usar en las preguntas penalizables. Tambien tenes dos exclusividades, que al usarla obtenes el doble de puntos" +
                " si solo un jugador respondio correctamente. (en preguntas con puntaje clasico y parcial)");
        super.setFont(Font.font("montserrat",20));
        super.setTextFill(Color.BLACK);
        super.setWrapText(true);
    }

}
