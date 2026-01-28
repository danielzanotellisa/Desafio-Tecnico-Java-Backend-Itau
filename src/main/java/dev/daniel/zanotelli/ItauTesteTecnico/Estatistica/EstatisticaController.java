package dev.daniel.zanotelli.ItauTesteTecnico.Estatistica;

import dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estatistica")

public class EstatisticaController {

    private TransacaoService service;
    public EstatisticaController(TransacaoService service) {
        this.service = service;
    }
    @GetMapping()
    public ResponseEntity<EstatisticaDTO> gerarEstatisticas() {

        return ResponseEntity.status(HttpStatus.OK).body(this.service.gerarEstatisticas());
    }
}
