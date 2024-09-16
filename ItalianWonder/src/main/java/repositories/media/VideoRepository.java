package repositories.media;

import classes.media.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
