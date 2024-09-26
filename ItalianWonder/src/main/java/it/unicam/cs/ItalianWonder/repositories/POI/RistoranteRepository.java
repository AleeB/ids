package it.unicam.cs.ItalianWonder.repositories.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RistoranteRepository extends JpaRepository<Ristorante, Long> {
  List<Ristorante> findByApprovazione(boolean approvazione);
}
