package it.unicam.cs.ItalianWonder.repositories.users;

import it.unicam.cs.ItalianWonder.classes.users.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TuristaRepository extends JpaRepository<Turista, Long> {

    Optional<Turista> findByUserNameAndPassword(String username, String password);

    Optional<Turista> findByUserName(String username);



}
