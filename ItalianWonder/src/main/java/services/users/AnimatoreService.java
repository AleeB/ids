package services.users;

import classes.users.Animatore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.users.AnimatoreRepository;

@Service
public class AnimatoreService {

    private final AnimatoreRepository animeRepository;

    @Autowired
    public AnimatoreService(AnimatoreRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

}
