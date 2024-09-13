package repositories.users;

import classes.users.Curatore;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuratoreRepository extends JpaRepository<Curatore, Long> {
}
