package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Ristorante;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.List;
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

  public List<Ristorante> getAllRistoranti() {
      return ristoranteRepository.findAll();
  }

  public void aggiungiRistorante(Ristorante ristorante) {
      ristoranteRepository.save(ristorante);
  }

  public void modificaRistorante(Ristorante ristorante) {
      ristoranteRepository.save(ristorante);
  }

  public void eliminaRistorante(Long id) {
      ristoranteRepository.deleteById(id);
  }
}
