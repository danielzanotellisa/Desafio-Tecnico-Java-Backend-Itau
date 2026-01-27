package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Repository;


import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransacaoRepository {

    List<TransacaoRequest> transacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacao){
        transacoes.add(transacao);
        System.out.println(this.transacoes);
    }

    public void limparDados() {}

    public void deletarDados(){
        transacoes.clear();
    }
}
