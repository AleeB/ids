package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.SegnalazioneRepository;

@Service

public class SegnalazioneService {

    private final SegnalazioneRepository segnalazioneRepository;

    @Autowired
    public SegnalazioneService(SegnalazioneRepository segnalazioneRepository) {
        this.segnalazioneRepository = segnalazioneRepository;
    }

    public void addNewSegnalazione(Segnalazione segnalazione) {
        segnalazioneRepository.save(segnalazione);
    }
}
