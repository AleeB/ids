package it.unicam.cs.ItalianWonder.repositories.users;

import it.unicam.cs.ItalianWonder.classes.users.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}
