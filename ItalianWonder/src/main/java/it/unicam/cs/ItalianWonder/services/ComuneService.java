package it.unicam.cs.ItalianWonder.services;

import it.unicam.cs.ItalianWonder.classes.Comune;
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

    public Optional<Comune> getAllComuni() {
        return Optional.of((Comune) comuneRepository.findAll());
    }
}
