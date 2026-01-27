package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Service;

import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.UnprocessableEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    public void validate(TransacaoRequest transacaoRequest) {

        if(transacaoRequest.valor() == null) {
            throw new UnprocessableEntity("valor");
        }

        if(transacaoRequest.dataHora() == null) {
            throw new UnprocessableEntity("dataHora");
        }

        if(transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("O valor deve ser maior ou igual a zero");
        }

        if(transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new IllegalArgumentException("A data da transação não pode ser no futuro");
        }
    }
}
