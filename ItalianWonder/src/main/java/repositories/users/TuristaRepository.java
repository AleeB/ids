package repositories.users;

import classes.users.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TuristaRepository extends JpaRepository<Turista, Long> {

    Optional<Turista> findByUsernameAndPassword();

}
