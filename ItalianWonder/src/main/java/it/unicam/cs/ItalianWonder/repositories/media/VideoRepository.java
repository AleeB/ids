package it.unicam.cs.ItalianWonder.repositories.media;

import it.unicam.cs.ItalianWonder.classes.media.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
