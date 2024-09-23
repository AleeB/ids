package it.unicam.cs.ItalianWonder.services.users;

import it.unicam.cs.ItalianWonder.classes.users.GestoreDellaPiattaforma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.GestoreDellaPiattaformaRepository;

@Service
public class GestoreDellaPiattaformaService {

    private final GestoreDellaPiattaformaRepository repository;

    @Autowired
    public GestoreDellaPiattaformaService(GestoreDellaPiattaformaRepository repository) {
        this.repository = repository;
    }

    public void save(GestoreDellaPiattaforma user) {
        repository.save(user);
    }
}
