package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Itinerario;
import it.unicam.cs.ItalianWonder.services.users.TuristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.POI.ItinerarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItinerarioService {

    private final ItinerarioRepository itinerarioRepository;
    private final TuristaService turistaService;

    @Autowired
    public ItinerarioService(ItinerarioRepository itinerarioRepository, TuristaService turistaService) {
        this.itinerarioRepository = itinerarioRepository;
        this.turistaService = turistaService;
    }

    public Boolean addItinerario(Itinerario itinerario) {
        Itinerario it = itinerarioRepository.findByTitolo(itinerario.getTitolo()).get();
        if(it.equals(itinerario)){
            return false;
        }
        itinerarioRepository.save(itinerario);
        return true;
    }

    public Optional<List<Itinerario>> getItinerariByApprovazione(Boolean approvazione) {
        return itinerarioRepository.findByApprovazione(approvazione);
    }
}
