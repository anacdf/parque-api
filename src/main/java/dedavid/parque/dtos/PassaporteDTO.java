package dedavid.parque.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PassaporteDTO {

    @GeneratedValue
    private long id;
    private String cliente;
    private int nroDias;
    private BigDecimal valorBasico;
    private BigDecimal valorTotal;
    private LocalDate dataInicial;
    private LocalDate dataVenda;

}
