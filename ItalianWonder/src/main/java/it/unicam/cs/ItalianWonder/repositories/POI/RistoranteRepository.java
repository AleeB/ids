package it.unicam.cs.ItalianWonder.repositories.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RistoranteRepository extends JpaRepository<Ristorante, Long> {
}
