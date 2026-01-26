package dev.daniel.zanotelli.ItauTesteTecnico.Transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
public class TransacoesController {

    @PostMapping()
    public ResponseEntity criarTransacao(RequestBody T) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping()
    public ResponseEntity deletarTransacao(RequestBody T) {
        return ResponseEntity.ok().build();
    }
}
