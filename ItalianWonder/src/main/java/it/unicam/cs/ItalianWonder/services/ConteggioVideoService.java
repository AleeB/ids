package it.unicam.cs.ItalianWonder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.ConteggioVideoRepository;

@Service

public class ConteggioVideoService {

    private final ConteggioVideoRepository aVRepository;

    @Autowired
    public ConteggioVideoService(ConteggioVideoRepository aVRepository) {
        this.aVRepository = aVRepository;
    }

}
