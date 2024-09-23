package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.Segnalazione;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoSegnalazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.SegnalazioneRepository;

import java.util.List;
import java.util.Optional;

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

    public List<Segnalazione> getSegnalazioneByTipo(enumTipoSegnalazione tipoSegnalazione){
        return segnalazioneRepository.findByTipo(tipoSegnalazione);
    }

    public void delete(Long idSegnalazione) {
        segnalazioneRepository.deleteById(idSegnalazione);
    }
}
