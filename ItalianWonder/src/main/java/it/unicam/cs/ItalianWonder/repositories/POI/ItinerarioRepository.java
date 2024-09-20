package it.unicam.cs.ItalianWonder.repositories.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItinerarioRepository extends JpaRepository<Itinerario, Long> {

    Optional<Itinerario> findByTitolo(String titolo);

    Optional<List<Itinerario>> findByApprovazione(Boolean approvazione);
}
