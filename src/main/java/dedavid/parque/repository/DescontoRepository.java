package dedavid.parque.repository;

import dedavid.parque.models.Desconto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Long> {

}
