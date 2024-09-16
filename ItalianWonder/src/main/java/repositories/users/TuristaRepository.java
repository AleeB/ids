package repositories.users;

import classes.users.Turista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TuristaRepository extends JpaRepository<Turista, Long> {
}
