package dedavid.parque.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "DESCONTOS")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Desconto {

    @Id
    @GeneratedValue
    private Long id;
    private String tipo;
    private String descricao;
    private BigDecimal valor;
    private boolean ativo;
}
