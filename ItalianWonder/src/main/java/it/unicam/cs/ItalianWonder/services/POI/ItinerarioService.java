package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.POI.ItinerarioRepository;

import java.util.List;

@Service
public class ItinerarioService {

    private final ItinerarioRepository itinerarioRepository;

    @Autowired
    public ItinerarioService(ItinerarioRepository itinerarioRepository) {
        this.itinerarioRepository = itinerarioRepository;
    }

    public List<Itinerario> getAllItinerari() {
        return itinerarioRepository.findAll();
    }

    public void addItinerario(Itinerario itinerario) {
        itinerarioRepository.save(itinerario);
    }

    public void updateItinerario(Itinerario itinerario) {
        itinerarioRepository.save(itinerario);
    }

    public void deleteItinerario(Long id) {
        itinerarioRepository.deleteById(id);
    }

    public List<Itinerario> getItinerarioByApprovazione(boolean approvazione) {
        return itinerarioRepository.findByApprovazione(approvazione).get();
    }
}
