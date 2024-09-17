package it.unicam.cs.ItalianWonder.repositories.media;

import it.unicam.cs.ItalianWonder.classes.media.Foto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto, Long> {

    Optional<Foto> findFotoByFoto(Foto foto);

}
