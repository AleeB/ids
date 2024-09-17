package it.unicam.cs.ItalianWonder.repositories;

import it.unicam.cs.ItalianWonder.classes.Comune;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComuneRepository extends JpaRepository<Comune, Long> {
}
