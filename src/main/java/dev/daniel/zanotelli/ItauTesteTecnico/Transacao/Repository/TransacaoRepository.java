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

        if (filtradas.size() == 0) {

            EstatisticaDTO estatistica = new EstatisticaDTO();
            estatistica.setCount(0L);
            estatistica.setAvg((double)0);
            estatistica.setMax((double)0);
            estatistica.setSum((double)0);
            estatistica.setMin((double)0);
            return estatistica;
        }

        List<BigDecimal> valores = filtradas.stream().map(transacao -> transacao.valor()).collect(Collectors.toList());
        Double max = Collections.max(valores).doubleValue();
        Double min = Collections.min(valores).doubleValue();
        OptionalDouble avg = valores.stream().mapToDouble(valor -> valor.doubleValue()).average();
        Double sum = valores.stream().mapToDouble(valor -> valor.doubleValue()).sum();
        Long count = valores.stream().count();

        EstatisticaDTO estatisticaDTO = new EstatisticaDTO();
        estatisticaDTO.setMin(min);
        estatisticaDTO.setAvg(avg.isPresent() ? avg.getAsDouble() : 0);
        estatisticaDTO.setCount(count);
        estatisticaDTO.setSum(sum);
        estatisticaDTO.setMax(max);

        return estatisticaDTO;
    }
}
