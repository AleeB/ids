package it.unicam.cs.ItalianWonder.repositories;

import it.unicam.cs.ItalianWonder.classes.Contest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContestRepository extends JpaRepository<Contest, Long> {
}
