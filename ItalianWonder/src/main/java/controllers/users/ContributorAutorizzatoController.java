package controllers.users;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.users.ContributorAutorizzatoService;

@RestController
@RequestMapping(path = "api/v1/contributorAutorizzato")

public class ContributorAutorizzatoController {
    private final ContributorAutorizzatoService contributorAutorizzatoService;

    public ContributorAutorizzatoController(ContributorAutorizzatoService contributorAutorizzatoService) {
        this.contributorAutorizzatoService = contributorAutorizzatoService;
    }
}