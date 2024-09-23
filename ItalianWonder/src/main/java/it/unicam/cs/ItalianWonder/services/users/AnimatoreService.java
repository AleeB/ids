package it.unicam.cs.ItalianWonder.services.users;

import it.unicam.cs.ItalianWonder.classes.users.Animatore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.AnimatoreRepository;

@Service
public class AnimatoreService {

    private final AnimatoreRepository animatoreRepository;

    @Autowired
    public AnimatoreService(AnimatoreRepository animatoreRepository) {
        this.animatoreRepository = animatoreRepository;
    }

    public void save(Animatore user) {
        animatoreRepository.save(user);
    }
}
