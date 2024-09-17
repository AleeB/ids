package it.unicam.cs.ItalianWonder.repositories.users;

import it.unicam.cs.ItalianWonder.classes.users.Curatore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratoreRepository extends JpaRepository<Curatore, Long> {
}
