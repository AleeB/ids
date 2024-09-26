package it.unicam.cs.ItalianWonder.services.POI;

import it.unicam.cs.ItalianWonder.classes.POI.Divertimento;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.POI.DivertimentoRepository;

@Service
public class DivertimentoService {

    private final DivertimentoRepository divertimentoRepository;

    @Autowired
    public DivertimentoService(DivertimentoRepository repository) {
        this.divertimentoRepository = repository;
    }

  public List<Divertimento> getAllDivertimenti() {
      return divertimentoRepository.findAll();
  }

  public void aggiungiDivertimento(Divertimento divertimento) {
      divertimentoRepository.save(divertimento);
  }

  public void modificaDivertimento(Divertimento divertimento) {
      divertimentoRepository.save(divertimento);
  }

  public void eliminaDivertimento(Long id) {
      divertimentoRepository.deleteById(id);
  }

  public List<Divertimento> getDivertimentoByApprovazione(boolean approvazione) {
      return divertimentoRepository.findByApprovazione(approvazione);
  }
}
