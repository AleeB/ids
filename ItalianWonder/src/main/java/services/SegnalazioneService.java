package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.SegnalazioneRepository;

@Service

public class SegnalazioneService {

    private final SegnalazioneRepository segnalazioneRepository;

    @Autowired
    public SegnalazioneService(SegnalazioneRepository segnalazioneRepository) {
        this.segnalazioneRepository = segnalazioneRepository;
    }

}
