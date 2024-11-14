package it.unicam.cs.ItalianWonder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.ConteggioFotoRepository;

@Service

public class ConteggioFotoService {

    private final ConteggioFotoRepository aFRepository;

    @Autowired
    public ConteggioFotoService(ConteggioFotoRepository aFRepository) {
        this.aFRepository = aFRepository;
    }

}
