package it.unicam.cs.ItalianWonder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.LocalizzazioneRepository;

@Service

public class LocalizzazioneService {

    private final LocalizzazioneRepository localizzazioneRepository;

    @Autowired
    public LocalizzazioneService(LocalizzazioneRepository localizzazioneRepository) {
        this.localizzazioneRepository = localizzazioneRepository;
    }

}
