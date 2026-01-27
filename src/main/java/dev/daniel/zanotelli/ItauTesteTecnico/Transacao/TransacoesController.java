package dev.daniel.zanotelli.ItauTesteTecnico.Transacao;

import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions.ErrorResponse;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Exceptions.UnprocessableContent;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request.TransacaoRequest;
import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Service.TransacaoService;
import jakarta.validation.Valid;
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
    public ResponseEntity criarTransacao(@Valid @RequestBody TransacaoRequest transacaoRequest) {

        try {
            service.validate(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (UnprocessableContent e) {
            ErrorResponse error = new ErrorResponse(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT.value());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(error);

        }
    }

    @DeleteMapping()
    public ResponseEntity deletarTransacao(RequestBody T) {
        return ResponseEntity.ok().build();
    }
}
