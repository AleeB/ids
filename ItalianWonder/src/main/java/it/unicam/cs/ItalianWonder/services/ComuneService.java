package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.Comune;
import it.unicam.cs.ItalianWonder.classes.enums.enumTipoUtente;
import it.unicam.cs.ItalianWonder.classes.users.Turista;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.ComuneRepository;

import java.util.Optional;

@Service

public class ComuneService {

    private final ComuneRepository comuneRepository;

    @Autowired
    public ComuneService(ComuneRepository comuneRepository) {
        this.comuneRepository = comuneRepository;
    }

    public List<Comune> getAllComuni() {
        return (comuneRepository.findAll());
    }

    public void aggiungiComune(Comune comune) {
        comuneRepository.save(comune);
    }

    @Transactional
    public void modificaComune(Comune comune) {
        comuneRepository.save(comune);
    }

    public void eliminaComune(String nomeComune) {
        comuneRepository.deleteById(nomeComune);
    }
}
