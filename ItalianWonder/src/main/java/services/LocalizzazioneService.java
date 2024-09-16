package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.LocalizzazioneRepository;

@Service

public class LocalizzazioneService {

    private final LocalizzazioneRepository localizzazioneRepository;

    @Autowired
    public LocalizzazioneService(LocalizzazioneRepository localizzazioneRepository) {
        this.localizzazioneRepository = localizzazioneRepository;
    }

}
