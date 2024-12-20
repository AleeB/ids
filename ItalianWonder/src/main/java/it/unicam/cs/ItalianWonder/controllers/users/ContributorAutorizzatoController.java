package it.unicam.cs.ItalianWonder.controllers.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.unicam.cs.ItalianWonder.services.users.ContributorAutorizzatoService;

@RestController
@RequestMapping(path = "api/v1/contributorAutorizzato")

public class ContributorAutorizzatoController {
    private final ContributorAutorizzatoService contributorAutorizzatoService;

    @Autowired
    public ContributorAutorizzatoController(ContributorAutorizzatoService contributorAutorizzatoService) {
        this.contributorAutorizzatoService = contributorAutorizzatoService;
    }
}
