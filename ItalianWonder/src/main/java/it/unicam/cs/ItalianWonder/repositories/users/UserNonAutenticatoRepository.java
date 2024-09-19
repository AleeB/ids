package it.unicam.cs.ItalianWonder.repositories.users;

import it.unicam.cs.ItalianWonder.classes.users.UserNonAutenticato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNonAutenticatoRepository extends JpaRepository<UserNonAutenticato, Long> {
}
