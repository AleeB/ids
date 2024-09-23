package it.unicam.cs.ItalianWonder.services.users;

import it.unicam.cs.ItalianWonder.classes.users.ContributorAutorizzato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unicam.cs.ItalianWonder.repositories.users.ContributorAutorizzatoRepository;

@Service

public class ContributorAutorizzatoService {

    private final ContributorAutorizzatoRepository contributorAutorizzatoRepository;

    @Autowired
    public ContributorAutorizzatoService(ContributorAutorizzatoRepository contributorAutorizzatoRepository){
        this.contributorAutorizzatoRepository = contributorAutorizzatoRepository;
    }

    public void save(ContributorAutorizzato user) {
        contributorAutorizzatoRepository.save(user);
    }
}
