package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.PuntoRistoro;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.POI.PuntoRistoroRepository;

@Service
public class PuntoRistoroService {

    private final PuntoRistoroRepository puntoRistoroRepository;

    @Autowired
    public PuntoRistoroService(PuntoRistoroRepository puntoRistoroRepository) {
        this.puntoRistoroRepository = puntoRistoroRepository;
    }

  public List<PuntoRistoro> getAllRistoranti() {
      return puntoRistoroRepository.findAll();
  }

  public void aggiungiPuntoRistoro(PuntoRistoro puntoRistoro) {
      puntoRistoroRepository.save(puntoRistoro);
  }

  public void modificaPuntoRistoro(PuntoRistoro puntoRistoro) {
      puntoRistoroRepository.save(puntoRistoro);
  }

  public void eliminaPuntoRistoro(Long id) {
      puntoRistoroRepository.deleteById(id);
  }

  public List<PuntoRistoro> getPuntoRistoroByApprovazione(boolean approvazione){
      return puntoRistoroRepository.findByApprovazione(approvazione);
  }
}
