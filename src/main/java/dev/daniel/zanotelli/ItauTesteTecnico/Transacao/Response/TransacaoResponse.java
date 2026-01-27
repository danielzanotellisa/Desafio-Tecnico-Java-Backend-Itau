package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Response;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoResponse(BigDecimal valor, OffsetDateTime dataHora) {
}
