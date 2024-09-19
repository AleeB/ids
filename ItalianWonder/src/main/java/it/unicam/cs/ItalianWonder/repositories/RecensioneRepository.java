package it.unicam.cs.ItalianWonder.repositories;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {

    Optional<Recensione> findByDivertimento(Divertimento divertimento);

    Optional<Recensione> findByItinerario(Itinerario itinerario);

    Optional<Recensione> findByRistorante(Ristorante ristorante);

    Optional<Recensione> findByID(Long id);

}
