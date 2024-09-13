package repositories.POI;

import classes.POI.Ristorante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RistoranteRepository extends JpaRepository<Ristorante, Long> {
}
