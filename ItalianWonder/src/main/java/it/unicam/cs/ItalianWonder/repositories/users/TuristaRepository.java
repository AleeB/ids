package it.unicam.cs.ItalianWonder.repositories.users;

import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface TuristaRepository extends JpaRepository<Turista, String> {

    Optional<Turista> findByUserNameAndPassword(String username, String password);

    Optional<Turista> findByUserName(String username);

    @Transactional
    @Query(value = "UPDATE turista SET dtype = ?1, tipo_user = ?2 WHERE user_name = ?3", nativeQuery = true)
    @Modifying
    void saveType(String dtype, enumTipoUtente tipoUser,String username);

}
