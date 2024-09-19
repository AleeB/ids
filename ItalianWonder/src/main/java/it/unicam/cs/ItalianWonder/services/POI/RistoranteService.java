package it.unicam.cs.ItalianWonder.services.POI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.POI.RistoranteRepository;

@Service
public class RistoranteService {

    private final RistoranteRepository ristoranteRepository;

    @Autowired
    public RistoranteService(RistoranteRepository ristoranteRepository) {
        this.ristoranteRepository = ristoranteRepository;
    }
}
