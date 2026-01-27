package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions;

public class UnprocessableEntity extends RuntimeException {

    private final String field;
    public UnprocessableEntity(String field) {
        super("Campos " + field + " são obrigatórios");
        this.field = field;
    }
}
