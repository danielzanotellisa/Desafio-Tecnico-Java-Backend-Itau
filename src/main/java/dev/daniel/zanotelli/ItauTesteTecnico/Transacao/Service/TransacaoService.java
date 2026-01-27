package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Service;

import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Repository.TransacaoRepository;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions.UnprocessableContent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Service
public class TransacaoService {

    private TransacaoRepository repository;
    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    protected void validate(TransacaoRequest transacaoRequest) {

        if(transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0) {
            throw new UnprocessableContent("O valor deve ser maior ou igual a zero");
        }

        if(transacaoRequest.dataHora().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableContent("A data da transação não pode ser no futuro");
        }
    }

    public void save(TransacaoRequest transacaoRequest) {
        this.validate(transacaoRequest);

        this.repository.salvarDados(transacaoRequest);
    }

    public void clear() {
        this.repository.deletarDados();
    }
}
