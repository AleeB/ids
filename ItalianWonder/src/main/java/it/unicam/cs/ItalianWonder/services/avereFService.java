package it.unicam.cs.ItalianWonder.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.avereFRepository;

@Service

public class avereFService {

    private final avereFRepository aFRepository;

    @Autowired
    public avereFService(avereFRepository aFRepository) {
        this.aFRepository = aFRepository;
    }

}
