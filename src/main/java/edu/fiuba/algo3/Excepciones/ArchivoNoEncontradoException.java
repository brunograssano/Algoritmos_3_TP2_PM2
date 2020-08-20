package edu.fiuba.algo3.Excepciones;

public class ArchivoNoEncontradoException extends RuntimeException {
    public ArchivoNoEncontradoException(String direccion) {
        super(direccion);
    }
}
