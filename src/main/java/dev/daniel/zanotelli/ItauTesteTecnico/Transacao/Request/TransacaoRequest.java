package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(BigDecimal valor, OffsetDateTime dataHora) {
}
