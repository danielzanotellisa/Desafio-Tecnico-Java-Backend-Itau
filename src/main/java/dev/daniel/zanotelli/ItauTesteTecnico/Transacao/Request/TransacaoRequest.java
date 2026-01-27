package dev.daniel.zanotelli.ItauTesteTecnico.Transacao.Request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(@NotNull(message = "O campo valor deve estar presente") BigDecimal valor,
                               @NotNull(message = "O campo dataHora deve estar presente") OffsetDateTime dataHora) {
}
