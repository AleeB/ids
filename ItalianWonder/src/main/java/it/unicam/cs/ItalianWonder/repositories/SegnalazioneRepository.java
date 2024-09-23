package it.unicam.cs.ItalianWonder.repositories;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoSegnalazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SegnalazioneRepository extends JpaRepository<Segnalazione, Long> {
    List<Segnalazione> findByTipo(enumTipoSegnalazione tipoSegnalazione);
}
