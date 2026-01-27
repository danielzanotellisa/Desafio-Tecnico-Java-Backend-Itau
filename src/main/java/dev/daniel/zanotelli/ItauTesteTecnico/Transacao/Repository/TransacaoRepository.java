package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Repository;


import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;

import java.util.ArrayList;
import java.util.List;

public class TransacaoRepository {

    List<TransacaoRequest> transacoes = new ArrayList<>();

    public void salvarDados(TransacaoRequest transacao){
        transacoes.add(transacao);
    }

    public void limparDados() {}

    public void deletarDados(){
        transacoes.clear();
    }
}
