package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
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

    public void addItinerario(Itinerario ristorante) {
        itinerarioRepository.save(ristorante);
    }

    public void updateItinerario(Itinerario ristorante) {
        itinerarioRepository.save(ristorante);
    }

    public void deleteItinerario(Long id) {
        itinerarioRepository.deleteById(id);
    }
}
