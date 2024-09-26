package it.unicam.cs.ItalianWonder.repositories.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivertimentoRepository extends JpaRepository<Divertimento, Long> {

  List<Divertimento> findByApprovazione(boolean approvazione);
}
