package it.unicam.cs.ItalianWonder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.avereVRepository;

@Service

public class avereVService {

    private final avereVRepository aVRepository;

    @Autowired
    public avereVService(avereVRepository aVRepository) {
        this.aVRepository = aVRepository;
    }

}
