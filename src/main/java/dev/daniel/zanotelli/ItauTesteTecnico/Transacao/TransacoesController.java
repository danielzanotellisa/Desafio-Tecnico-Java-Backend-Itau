package dev.daniel.zanotelli.ItauTesteTecnico.Transacao;

import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Service.TransacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    private final TransacaoService service;
    public TransacoesController(TransacaoService service) {
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity criarTransacao(@RequestBody TransacaoRequest transacaoRequest) {

        service.validate(transacaoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping()
    public ResponseEntity deletarTransacao(RequestBody T) {
        return ResponseEntity.ok().build();
    }
}
