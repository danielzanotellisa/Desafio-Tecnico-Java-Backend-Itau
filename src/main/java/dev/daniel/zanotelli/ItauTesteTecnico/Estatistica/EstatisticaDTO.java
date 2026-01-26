package dev.daniel.zanotelli.ItauTesteTecnico.Estatistica;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstatisticaDTO {
    private Long count;
    private Double sum;
    private Double avg;
    private Double min;
    private Double max;
}
