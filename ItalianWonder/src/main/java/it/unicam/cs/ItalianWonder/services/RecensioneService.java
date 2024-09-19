package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.RecensioneRepository;

import java.util.Optional;

@Service

public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    @Autowired
    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

    public void addNewRecensione(Recensione recensione) {
        recensioneRepository.saveAndFlush(recensione);
    }

    public boolean deleteRecensione(Recensione recensione) {
        if(recensioneRepository.findById(recensione.getID()).isEmpty()){
            return false;
        }
        recensioneRepository.delete(recensione);
        return true;
    }

    public Optional<Recensione> getRecensioneByDivertimento(Divertimento divertimento) {
        return recensioneRepository.findByDivertimento(divertimento);
    }

    public Optional<Recensione> getRecensioneByItinerario(Itinerario itinerario) {
        return recensioneRepository.findByItinerario(itinerario);
    }

    public Optional<Recensione> getRecensioneByRistorante(Ristorante ristorante) {
        return recensioneRepository.findByRistorante(ristorante);
    }

    public boolean updateRecensione(Recensione recensione) {
        Optional<Recensione> rec = recensioneRepository.findById(recensione.getID());
        if(rec.isEmpty()){
            return false;
        }
        recensioneRepository.save(recensione);
        return true;
    }
}
