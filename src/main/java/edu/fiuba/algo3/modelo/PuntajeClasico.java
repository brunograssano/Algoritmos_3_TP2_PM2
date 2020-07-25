package edu.fiuba.algo3.modelo;

public class PuntajeClasico implements Puntaje {
    @Override
    public int evaluar(Resultado unResultado) {
        return unResultado.calcularClasico();
    }
    /*
    @Override
    public int evaluar(MetodoRespuesta metodo, ArrayList<RespuestaComun> respuestas) {
        return metodo.evaluarClasico(respuestas);
    }

     */

}
