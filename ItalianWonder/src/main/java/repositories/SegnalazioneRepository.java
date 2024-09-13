package repositories;

import classes.Segnalazione;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SegnalazioneRepository extends JpaRepository<Segnalazione, Integer> {
}
