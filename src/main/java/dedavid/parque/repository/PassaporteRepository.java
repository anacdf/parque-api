package dedavid.parque.repository;

import dedavid.parque.models.Passaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassaporteRepository extends JpaRepository<Passaporte, Long> {

}
