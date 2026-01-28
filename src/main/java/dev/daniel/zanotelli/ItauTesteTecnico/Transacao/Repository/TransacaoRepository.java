package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Repository;


import dev.daniel.zanotelli.ItauTesteTecnico.Estatistica.EstatisticaDTO;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> transacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacao){
        transacoes.add(transacao);
        System.out.println(OffsetDateTime.now());
    }

    public void deletarDados(){
        transacoes.clear();
    }

    public EstatisticaDTO gerarEstatisticas() {
        List<TransacaoRequest> filtradas = this.transacoes.stream()
                .filter(transacao -> transacao.dataHora().isAfter(OffsetDateTime.now().minusSeconds(60)))
                .collect(Collectors.toList());

        if (filtradas.isEmpty()) {
            return new EstatisticaDTO(0L,0.0,0.0,0.0,0.0);
        }

        final var summary = filtradas.stream().mapToDouble(t -> t.valor().doubleValue()).summaryStatistics();

        return new EstatisticaDTO(
                summary.getCount(),
                summary.getSum(),
                summary.getAverage(),
                summary.getMin(),
                summary.getMax());
    }
}
