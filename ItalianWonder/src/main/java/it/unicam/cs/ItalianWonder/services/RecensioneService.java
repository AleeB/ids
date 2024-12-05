package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;
import it.unicam.cs.ItalianWonder.classes.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.RecensioneRepository;

import java.util.List;
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

    public boolean deleteRecensione(Long recensione_id) {
        Optional<Recensione> recensione = getRecensioneByID(recensione_id);
        if(recensione.isEmpty()){
            return false;
        }
        recensioneRepository.delete(recensione.get());
        return true;
    }

    public Optional<Recensione> getRecensioneByID(Long recensioneId) {
        return recensioneRepository.findById(recensioneId);
    }

    public Optional<List<Recensione>> getRecensioneByDivertimento(Divertimento divertimento) {
        return recensioneRepository.findByDivertimento(divertimento);
    }

    public Optional<List<Recensione>> getRecensioneByItinerario(Itinerario itinerario) {
        return recensioneRepository.findByItinerario(itinerario);
    }

    public Optional<List<Recensione>> getRecensioneByPuntoRistoro(PuntoRistoro puntoRistoro) {
        return recensioneRepository.findByPuntoRistoro(puntoRistoro);
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
