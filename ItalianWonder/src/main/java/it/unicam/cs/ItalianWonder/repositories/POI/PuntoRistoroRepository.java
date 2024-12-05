package it.unicam.cs.ItalianWonder.repositories.POI;

import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PuntoRistoroRepository extends JpaRepository<PuntoRistoro, Long> {
  List<PuntoRistoro> findByApprovazione(boolean approvazione);
}
