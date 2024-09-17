package it.unicam.cs.ItalianWonder.services.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.AnimatoreRepository;

@Service
public class AnimatoreService {

    private final AnimatoreRepository animeRepository;

    @Autowired
    public AnimatoreService(AnimatoreRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

}
