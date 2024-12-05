package it.unicam.cs.ItalianWonder.repositories;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecensioneRepository extends JpaRepository<Recensione, Long> {

    Optional<List<Recensione>> findByDivertimento(Divertimento divertimento);

    Optional<List<Recensione>> findByItinerario(Itinerario itinerario);

    Optional<List<Recensione>> findByPuntoRistoro(PuntoRistoro puntoRistoro);

    Optional<Recensione> findByID(Long id);

}
