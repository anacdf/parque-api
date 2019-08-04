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
import java.time.LocalDate;

@Entity
@Table(name = "PASSAPORTES")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passaporte {

    @Id
    @GeneratedValue
    private Long id;
    private String cliente;
    private int nroDias;
    private int nroEntradas;
    private BigDecimal valorBasico;
    private BigDecimal valorTotal;
    private LocalDate dataInicial;
    private LocalDate dataVenda;
}
