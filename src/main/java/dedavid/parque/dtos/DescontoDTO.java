package dedavid.parque.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DescontoDTO {

    @GeneratedValue
    private long id;
    private String tipo;
    private BigDecimal valor;
    private boolean ativo;
}
