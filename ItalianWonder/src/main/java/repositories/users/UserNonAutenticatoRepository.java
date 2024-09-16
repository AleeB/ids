package repositories.users;

import classes.users.UserNonAutenticato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserNonAutenticatoRepository extends JpaRepository<UserNonAutenticato, Long> {
}
