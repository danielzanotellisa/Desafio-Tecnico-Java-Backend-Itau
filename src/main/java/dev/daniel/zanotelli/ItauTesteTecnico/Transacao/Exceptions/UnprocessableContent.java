package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions;

public class UnprocessableContent extends RuntimeException {


    public UnprocessableContent( String message) {
        super(message);
    }
}
